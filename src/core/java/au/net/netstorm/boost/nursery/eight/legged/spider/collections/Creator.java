package au.net.netstorm.boost.nursery.eight.legged.spider.collections;

public interface Creator<K, V> {
    V create(K key);
}
