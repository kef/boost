package au.net.netstorm.boost.gunge.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Set;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultIntegrityMap<K, V> extends Primordial implements IntegrityMap<K, V> {
    private final ConcurrentMap<K,V> delegate = new ConcurrentHashMap<K,V>();

    public V getOrCreate(K key, Creator<K, V> creator) {
        V cached = delegate.get(key);
        if (cached != null) return cached;
        V newy = creator.create(key);
        V old = delegate.putIfAbsent(key, newy);
        return old != null ? old : newy;
    }

    public V getOrBomb(K key) {
        V value = delegate.get(key);
        if (value == null) throw new IllegalArgumentException();
        return value;
    }

    public Set<K> keySet() {
        return delegate.keySet();
    }
}
