package au.net.netstorm.boost.gunge.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;

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

    public Collection<V> getAll() {
        return delegate.values();
    }

    public Set<K> keySet() {
        return delegate.keySet();
    }

    // FIX 2394 relook at this, not sure if this is what should really be here
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
