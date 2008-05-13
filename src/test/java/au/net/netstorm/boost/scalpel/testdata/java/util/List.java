package au.net.netstorm.boost.scalpel.testdata.java.util;

import java.util.Iterator;
import au.net.netstorm.boost.scalpel.core.Edge;

public interface List<T> extends Edge, Iterable<T> {
    Iterator<T> iterator();
}
