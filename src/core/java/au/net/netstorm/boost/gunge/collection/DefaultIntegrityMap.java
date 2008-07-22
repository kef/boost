package au.net.netstorm.boost.gunge.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultIntegrityMap<K, V> extends Primordial implements IntegrityMap<K, V> {
    private final ConcurrentMap<K,V> delegate = new ConcurrentHashMap<K,V>();

    public V get(K key, Action<K, V> action) {
        V cached = delegate.get(key);
        if (cached != null) return cached;
        V newy = action.apply(key);
        V old = delegate.putIfAbsent(key, newy);
        return old != null ? old : newy;
    }

    public void put(K key, V value) {
        V old = delegate.putIfAbsent(key, value);
        if (old != null) throw new IllegalArgumentException();
    }

    public V replace(K key, V value) {
        if (!delegate.containsKey(key)) throw new IllegalArgumentException("Key not set.");
        return delegate.put(key, value);
    }

    public Iterator<K> iterator() {
        Set<K> keys = delegate.keySet();
        return keys.iterator();
    }
}
