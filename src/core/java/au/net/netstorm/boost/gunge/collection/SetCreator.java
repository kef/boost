package au.net.netstorm.boost.gunge.collection;

import java.util.HashSet;
import java.util.Set;

public final class SetCreator<K, V extends Set> implements Creator<K, V> {
    public V apply(K k) {
        return (V) new HashSet();
    }
}