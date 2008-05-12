package au.net.netstorm.boost.edge.testdata.java.util;

import java.util.Iterator;

import au.net.netstorm.boost.edge.core.Edge;

public interface List<T> extends Edge, Iterable<T> {
    Iterator<T> iterator();
}
