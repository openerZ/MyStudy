package com.mynote;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存算法：基于LinkedHashMap实现
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    public static int a=188;

    //缓存最大条目
    private static final int MAX_ENTRIES = 3;

    public LRUCache() {
        //开启访问顺序，调用父类构造函数将accessOrder设为true
        super(3, 0.75f, true);
    }

    //重写removeEldestEntry()方法当超过最大缓存条目时进行删除
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }

    public static void main(String[] args) {

        LRUCache<String, Integer> cache = new LRUCache<>();
        cache.put("a",1);
        cache.put("b",2);
        cache.get("a");
        cache.put("c",3);
        System.out.println(cache.keySet());
        System.out.println(cache.size());
        cache.put("d",4);
        cache.get("a");
        cache.put("e",5);
        System.out.println(cache.keySet());
        cache.put("f",6);
        cache.get("a");
        cache.put("g",7);
        System.out.println(cache.keySet());
        Iterator<String> iterator = cache.keySet().iterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(cache.size());
    }
}
