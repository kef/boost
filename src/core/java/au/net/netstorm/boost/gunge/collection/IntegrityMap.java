package au.net.netstorm.boost.gunge.collection;

public interface IntegrityMap<K, V> extends Iterable<K> {
    V get(K key, Action<K, V> action);

    void put(K key, V value);

    V replace(K key, V value);
}
