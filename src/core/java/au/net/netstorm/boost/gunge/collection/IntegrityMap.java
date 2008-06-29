package au.net.netstorm.boost.gunge.collection;

public interface IntegrityMap<K, V> {
    V getOrCreate(K key, Creator<K, V> creator);
}
