package guava;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class GuavaCacheTest {
    public static void main(String[] args) throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100000L).expireAfterWrite(5, TimeUnit.SECONDS).recordStats().removalListener(new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> removalNotification) {
                System.out.println("current remove from cache is = " + removalNotification.toString());
            }
        }).build();
//        LoadingCache
        cache.put("key1", "1");
        cache.put("key2", "2");
        cache.put("key3", "3");
        cache.put("key4", "4");

        String key1 = cache.get("key1", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "default";
            }
        });
        System.out.println("key1 = " + key1);
        Thread.sleep(5000);


        String key2 = cache.get("key2", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "default";
            }
        });
        System.out.println("key2 = " + key2);

        Thread.sleep(1000);

//        String key3 = cache.get("key3", new Callable<String>() {
//            public String call() throws Exception {
//                return "default";
//            }
//        });
//        System.out.println("key3 = " + key3);

        System.out.println("cache is =" + cache.asMap() + ",cache size = " + cache.size() + ",cache hit =" + cache.stats().hitCount());
        Thread.sleep(4000);
        System.out.println("cache is =" + cache.asMap() + ",cache size = " + cache.size() + ",cache hit =" + cache.stats().hitCount());

    }
}
