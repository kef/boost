package au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections;

public final class DefaultIntegrityMap<K, V> implements IntegrityMap<K, V> {
    public V getOrCreate(K key, Creator<V> creator) {
        throw new UnsupportedOperationException();
    }
}
