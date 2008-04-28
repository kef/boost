package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DefaultIterableMaster implements IterableMaster {
    public <T> Iterable<T> toIterable(Iterator<T> i) {
        return new IteratorIterable<T>(i);
    }
    public <T> Collection<T> toCollection(Iterator<T> iterator) {
        Iterable<T> iterable = toIterable(iterator);
        return toCollection(iterable);
    }

    public <T> Collection<T> toCollection(Iterable<T> iterable) {
        List<T> l = new ArrayList<T>();
        for (T t : iterable) l.add(t);
        return l;
    }
}
