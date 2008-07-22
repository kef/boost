package au.net.netstorm.boost.gunge.collection;

import java.util.Collection;
import java.util.Set;

// FIX 2394 this guy might serve as a replacement for strict map - elliminates dirty exists() method
// FIX 2394 for general purpose use, might want a concurrent and non-concurrent implementation
// FIX 2394 split.
public interface IntegrityMap<K, V> extends Iterable<K> {
    // FIX 2394 these three could be come one: V get(K key, Action action)
    V get(K key, Creator<K, V> creator);

    V get(K key, Failer<K> failer);

    V get(K key);

    // FIX 2394 Use or lose. Probably should lose. Force use of Iterable.
    Collection<V> getAll();

    // FIX 2394 Elliminate the need for this. Use Iterable.
    Set<K> keySet();

    void put(K key, V value);

    V replace(K key, V value);
}
