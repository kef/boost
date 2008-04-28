package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;
import java.util.Iterator;

public class MapperIterator<S,T> implements Iterator<T> {
    private Iterator<S> iter;
    private Mapper<S,T> mapper;
    public MapperIterator(Collection<S> collection, Mapper<S,T> mapper) {
        this.iter = collection.iterator();
        this.mapper = mapper;
    }

    public boolean hasNext() {
        return iter.hasNext();
    }

    public T next() {
        S src = iter.next();
        return mapper.map(src);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
