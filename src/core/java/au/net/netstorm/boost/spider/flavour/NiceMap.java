package au.net.netstorm.boost.spider.flavour;

public interface NiceMap<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean exists(K key);

    void clear();
}
