package au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections;

public interface Creator<K, V> {
    V create(K key);
}
