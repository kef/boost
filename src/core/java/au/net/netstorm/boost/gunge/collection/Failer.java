package au.net.netstorm.boost.gunge.collection;

public interface Failer<K> {
    void fail(K key);
}
