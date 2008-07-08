package au.net.netstorm.boost.gunge.collection;

import java.util.Set;

// FIX 2394 this guy might serve as a replacement for strict map
public interface IntegrityMap<K, V> {
    V get(K key, Creator<K, V> creator);

    // FIX 2394 name. could be just get.
    V get(K key);

    Set<K> keySet();
}
