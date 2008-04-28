package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Iterator;

public class IteratorIterable<T> implements Iterable<T> {
    private final Iterator<T> iterator;
    public IteratorIterable(Iterator<T> iterator) { this.iterator = iterator; }
    public Iterator<T> iterator() { return iterator; }
}
