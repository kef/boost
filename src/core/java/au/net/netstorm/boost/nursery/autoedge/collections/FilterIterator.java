package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;
import java.util.Iterator;

public class FilterIterator<T> implements Iterator<T> {
    private Iterator<T> iter;
    private Filter<T> filter;
    private T next;
    public FilterIterator(Collection<T> collection, Filter<T> filter) {
        this.iter = collection.iterator();
        this.filter = filter;
        this.next = findNext();
    }

    public boolean hasNext() {
        return next != null;
    }

    public T next() {
        T result = next;
        next = findNext();
        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public T findNext() {
        while (iter.hasNext()) {
            T t = iter.next();
            if (filter.accept(t)) return t;
        }
        return null;
    }
}
