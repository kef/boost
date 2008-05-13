package demo.edge.java.lang;

import au.net.netstorm.boost.scalpel.core.Edge;

public interface Class<T> extends Edge {
    T newInstance();
}
