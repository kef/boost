package demo.edge.java.lang;

import au.net.netstorm.boost.scalpel.core.Edge;

public interface ClassStatic extends Edge {
    Class<?> forName(String name);
}
