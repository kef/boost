package au.net.netstorm.boost.edge.testdata.java.util;

import java.util.Iterator;

import au.net.netstorm.boost.edge.core.Edge;

public interface BadList<T> extends Edge {
    Iterator<T> getIterator(); // method should not match
}

