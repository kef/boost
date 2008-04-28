package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DefaultCollectionFixture implements CollectionFixture {
    private Collection<String> collection = new ArrayList<String>();
    private Collection<String> mappedCollection = new ArrayList<String>();
    {
        collection.add(element());
        collection.add(element());
        collection.add(element());
        mappedCollection.add(mappedElement());
        mappedCollection.add(mappedElement());
        mappedCollection.add(mappedElement());
    }
    private Iterator<String> iterator = collection.iterator();
    private Iterator<String> mappedIterator = mappedCollection.iterator();

    public Collection<String> collection() {
        return collection;
    }

    public Collection<String> mappedCollection() {
        return mappedCollection;
    }

    public Iterator<String> iterator() {
        return iterator;
    }

    public Iterator<String> mappedIterator() {
        return mappedIterator;
    }

    public String element() {
        return "foo";
    }

    public String mappedElement() {
        return "bar";
    }
}
