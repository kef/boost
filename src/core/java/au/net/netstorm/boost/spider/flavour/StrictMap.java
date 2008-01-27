package au.net.netstorm.boost.spider.flavour;

public interface StrictMap<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean exists(K key);

    void remove(K key);

    void clear();
}
