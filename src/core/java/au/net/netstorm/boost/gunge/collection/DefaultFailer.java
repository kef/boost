package au.net.netstorm.boost.gunge.collection;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultFailer<K> extends Primordial implements Failer<K> {
    public void fail(K key) {
        throw new IllegalArgumentException("Key does not exist: " + key);
    }
}
