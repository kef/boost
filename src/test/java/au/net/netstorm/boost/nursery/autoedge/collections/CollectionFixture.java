package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;
import java.util.Iterator;

public interface CollectionFixture {
    String element();
    String mappedElement();
    Iterator<String> iterator();
    Iterator<String> mappedIterator();
    Collection<String> collection();
    Collection<String> mappedCollection();
}
