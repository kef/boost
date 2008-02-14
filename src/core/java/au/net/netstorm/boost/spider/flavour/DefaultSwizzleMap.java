package au.net.netstorm.boost.spider.flavour;

public final class DefaultSwizzleMap<K, V> implements SwizzleMap<K, V> {
    StrictMap<K, V> swizzle = strict();
    StrictMap<V, K> deswizzle = strict();

    public V swizzle(K id) {
        return swizzle.get(id);
    }

    public K deswizzle(V attribute) {
        return deswizzle.get(attribute);
    }

    public void put(K key, V value) {
        swizzle.put(key, value);
        deswizzle.put(value, key);
    }

    private <K, V> StrictMap<K, V> strict() {
        return new DefaultStrictMap<K, V>();
    }
}
