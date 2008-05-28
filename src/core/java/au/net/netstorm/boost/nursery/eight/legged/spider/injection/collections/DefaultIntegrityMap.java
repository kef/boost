package au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

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
