package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;
import java.util.Iterator;

public interface IterableMaster {
    <T> Iterable<T> toIterable(Iterator<T> iterator);
    <T> Collection<T> toCollection(Iterable<T> iterable);
    <T> Collection<T> toCollection(Iterator<T> iterator);
}
