package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;
import java.util.Iterator;

public class DefaultSuperCollection implements SuperCollection {
    IterableMaster iterable;

    public <T> Collection<T> filter(Collection<T> c, Filter<T> filter) {
        Iterator<T> filterator = new FilterIterator<T>(c, filter);
        return iterable.toCollection(filterator);
    }

    public <S, T> Collection<T> map(Collection<S> c, Mapper<S, T> map) {
        Iterator<T> mapperator = new MapperIterator<S,T>(c, map);
        return iterable.toCollection(mapperator);
    }
}
