package au.net.netstorm.boost.spider.flavour;

public interface SwizzleMap<K, V> {
    V swizzle(K key);

    K deswizzle(V value);

    void put(K key, V value);
}
