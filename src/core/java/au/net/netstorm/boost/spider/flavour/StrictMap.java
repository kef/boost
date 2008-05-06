package au.net.netstorm.boost.spider.flavour;

// FIX 2318 Does not belong here.
public interface StrictMap<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean exists(K key);

    void remove(K key);

    void clear();
}
