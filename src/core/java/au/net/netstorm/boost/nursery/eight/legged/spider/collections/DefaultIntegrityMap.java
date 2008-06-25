package au.net.netstorm.boost.nursery.eight.legged.spider.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class DefaultIntegrityMap<K, V> implements IntegrityMap<K, V> {
    private final ConcurrentMap<K,V> delegate = new ConcurrentHashMap<K,V>();

    public V getOrCreate(K key, Creator<K, V> creator) {
        V cached = delegate.get(key);
        if (cached != null) return cached;
        V newy = creator.create(key);
        delegate.putIfAbsent(key, newy);
        return delegate.get(key);
    }
}
