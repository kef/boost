package au.net.netstorm.boost.gunge.collection;

public interface Action<K,V> {
    V apply(K key);
}
