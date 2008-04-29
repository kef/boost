package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class DefaultCollectionFixture implements CollectionFixture {
    private String[] array = { element(), element(), element()};
    private String[] mappedArray = { mappedElement(), mappedElement(), mappedElement()};
    private Collection<String> collection = Arrays.asList(array);
    private Collection<String> mappedCollection = Arrays.asList(mappedArray);
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

    public String[] array() {
        return array;
    }

    public String[] mappedArray() {
        return mappedArray;
    }
}
