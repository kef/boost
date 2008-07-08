package au.net.netstorm.boost.gunge.collection;

import java.util.Set;

public interface IntegrityMap<K, V> {
    V getOrCreate(K key, Creator<K, V> creator);

    // FIX 2394 name. could be just get.
    V get(K key);

    Set<K> keySet();
}
