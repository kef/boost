package au.net.netstorm.boost.gunge.collection;

public interface Creator<K, V> {
    V create(K key);
}
