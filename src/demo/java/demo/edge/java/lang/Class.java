package demo.edge.java.lang;

import au.net.netstorm.boost.edge.core.Edge;

public interface Class<T> extends Edge<java.lang.Class<T>> {
    T newInstance();
}
