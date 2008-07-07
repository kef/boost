package au.net.netstorm.boost.gunge.collection;

import java.util.Set;

public interface IntegrityMap<K, V> {
    V getOrCreate(K key, Creator<K, V> creator);

    Set<K> keySet();
}
