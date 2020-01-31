package flink.window;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class WindowMain {
    public static final long DELAY = 3000L;
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStream<String> source = env.fromElements("zhushang,1553936163000", "sun,1553936173000","zhaoqian,1553936172000", "zhuyouyou,1553936175000","other,1553936180000");
        source.flatMap(new FlatMapFunction<String, Tuple2<String, Long>>() {
            @Override
            public void flatMap(String s, Collector<Tuple2<String, Long>> collector) throws Exception {
                collector.collect(Tuple2.of(s.split(",")[0], Long.parseLong(s.split(",")[1])));
            }
        }).assignTimestampsAndWatermarks(new AssignerWithPeriodicWatermarks<Tuple2<String, Long>>() {
            private long currentTimeStamp;
            @Nullable
            @Override
            public Watermark getCurrentWatermark() {
                return new Watermark(currentTimeStamp-DELAY);
            }

            @Override
            public long extractTimestamp(Tuple2<String, Long> element, long previousElementTimestamp) {
                long eventTime = element.f1;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                currentTimeStamp = Math.max(eventTime, currentTimeStamp);
                System.out.println("水印时间为："+sdf.format(getCurrentWatermark().getTimestamp()));
                return eventTime;
            }
        }).windowAll(TumblingEventTimeWindows.of(Time.seconds(10))).apply(new AllWindowFunction<Tuple2<String,Long>, Object, TimeWindow>() {
            @Override
            public void apply(TimeWindow window, Iterable<Tuple2<String, Long>> values, Collector<Object> out) throws Exception {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                Map<String, String> map = new HashMap<>();
                values.forEach(s->map.put(s.f0,sdf.format(s.f1)));
                String result = "窗口开始时|间："+sdf.format(window.getStart())+",窗口结束时间："+sdf.format(window.getEnd())+",窗口中的数据:"+map.toString();
                out.collect(result);
            }}).print();
        env.execute();

    }
}
