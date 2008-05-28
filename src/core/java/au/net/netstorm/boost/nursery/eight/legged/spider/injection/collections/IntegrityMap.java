package au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections;

public interface IntegrityMap<K, V> {
    V getOrCreate(K key, Creator<K, V> creator);
}
