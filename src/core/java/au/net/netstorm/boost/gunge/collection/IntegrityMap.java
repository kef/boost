package au.net.netstorm.boost.gunge.collection;

import java.util.Set;

// FIX 2394 this guy might serve as a replacement for strict map - elliminates dirty exists() method
// FIX 2394 for general purpose use, might want a concurrent and non-concurrent implementation
public interface IntegrityMap<K, V> {
    V get(K key, Creator<K, V> creator);

    V get(K key, Failer<K> failer);

    V get(K key);

    // FIX 2394 can this class just be made iterable, only ever allow iteration over keys
    // FIX 2394 force use of different datastructure if you are trying to iterate over values
    Set<K> keySet();

    void put(K key, V value);
}
