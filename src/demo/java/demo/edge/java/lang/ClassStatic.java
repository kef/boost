package demo.edge.java.lang;

import au.net.netstorm.boost.edge.core.Edge;

public interface ClassStatic extends Edge {
    Class<?> forName(String name);
}
