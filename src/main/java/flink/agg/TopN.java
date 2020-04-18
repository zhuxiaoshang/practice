package flink.agg;

import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.aggregation.AggregationFunction;
import org.apache.flink.api.java.tuple.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.triggers.ContinuousProcessingTimeTrigger;
import org.apache.flink.streaming.api.windowing.triggers.Trigger;
import org.apache.flink.streaming.api.windowing.triggers.TriggerResult;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.windowing.windows.Window;
import org.apache.flink.util.Collector;

public class TopN {

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStreamSource<Tuple2<String,Long>> source = env.fromElements(Tuple2.of("item1",10L));
        source.keyBy(f->f.f0).timeWindow(Time.days(1)).trigger(ContinuousProcessingTimeTrigger.of(Time.seconds(1))).aggregate(new AggreatePayAmt(),new MyWindowFunction()).keyBy(f->f.f2).process(new KeyedProcessFunction<Long, Tuple3<String, Long, Long>, Object>() {
            @Override
            public void processElement(Tuple3<String, Long, Long> value, Context ctx, Collector<Object> out) throws Exception {

            }

            @Override
            public void open(Configuration parameters) throws Exception {
                super.open(parameters);
            }
        });
    }

    static class AggreatePayAmt implements AggregateFunction<Tuple2<String,Long>,Long,Long>{
        @Override
        public Long createAccumulator() {
            return 0L;
        }

        @Override
        public Long add(Tuple2<String, Long> stringLongTuple2, Long aLong) {
            return stringLongTuple2.f1+aLong;
        }

        @Override
        public Long getResult(Long aLong) {
            return aLong;
        }

        @Override
        public Long merge(Long aLong, Long acc1) {
            return aLong+acc1;
        }
    }

    static class MyWindowFunction implements WindowFunction<Long,Tuple3<String,Long,Long>,String,TimeWindow>{



        /**
         * Evaluates the window and outputs none or several elements.
         *
         * @param s      The key for which this window is evaluated.
         * @param window The window that is being evaluated.
         * @param input  The elements in the window being evaluated.
         * @param out    A collector for emitting elements.
         * @throws Exception The function may throw exceptions to fail the program and trigger recovery.
         */
        @Override
        public void apply(String s, TimeWindow window, Iterable<Long> input, Collector<Tuple3<String, Long, Long>> out) throws Exception {
            out.collect(Tuple3.of(s,input.iterator().next(),window.getEnd()));
        }
    }
}
