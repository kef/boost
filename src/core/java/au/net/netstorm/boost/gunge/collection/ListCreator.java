package au.net.netstorm.boost.gunge.collection;

import java.util.List;
import java.util.ArrayList;

public final class ListCreator<K, V extends List> implements Creator<K, V> {
    public V apply(K k) {
        return (V) new ArrayList();
    }
}
