package au.net.netstorm.boost.gunge.collection;

import java.util.Collection;
import java.util.Iterator;

public interface CollectionFixture {
    String element();
    String mappedElement();
    Iterator<String> iterator();
    Iterator<String> mappedIterator();
    Collection<String> collection();
    Collection<String> mappedCollection();
    String[] array();
    String[] mappedArray();
}
