package au.net.netstorm.boost.gunge.collection;

import java.util.List;
import java.util.ArrayList;

public final class ArrayListCreator<K, V extends List> implements Creator<K, V> {
    public V create(K key) {
        return (V) new ArrayList();
    }
}
