package au.net.netstorm.boost.gunge.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Set;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultIntegrityMap<K, V> extends Primordial implements IntegrityMap<K, V> {
    private final ConcurrentMap<K,V> delegate = new ConcurrentHashMap<K,V>();

    public V get(K key, Creator<K, V> creator) {
        V cached = delegate.get(key);
        if (cached != null) return cached;
        V newy = creator.create(key);
        V old = delegate.putIfAbsent(key, newy);
        return old != null ? old : newy;
    }

    public V get(K key, Failer<K> failer) {
        V value = delegate.get(key);
        if (value == null) failer.fail(key);
        return value;
    }

    public V get(K key) {
        Failer<K> failer = new DefaultFailer<K>();
        return get(key, failer);
    }

    public Set<K> keySet() {
        return delegate.keySet();
    }

    // FIX 2394 relook at this, not sure if this is what should really be here
    public void put(K key, V value) {
        V old = delegate.putIfAbsent(key, value);
        if (old != null) throw new IllegalArgumentException();
    }
}
