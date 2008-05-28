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
        // FIX 2394 this is a bit ordinary, could avoid this lookup, but...
        // FIX 2394 it would be impossible to test, in fact it would not be
        // FIX 2394 executes on some platforms
        return delegate.get(key);
    }
}
