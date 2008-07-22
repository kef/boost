package au.net.netstorm.boost.gunge.collection;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultFailer<K, V> extends Primordial implements Failer<K, V> {
    public V apply(K key) {
        throw new IllegalArgumentException("Key does not exist: " + key);
    }
}
