package au.net.netstorm.boost.scalpel.testdata.java.util;

import java.util.Iterator;
import au.net.netstorm.boost.scalpel.core.Edge;

public interface BadList<T> extends Edge {
    Iterator<T> getIterator(); // method should not match
}

