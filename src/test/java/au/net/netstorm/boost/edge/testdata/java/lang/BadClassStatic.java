package au.net.netstorm.boost.edge.testdata.java.lang;

import au.net.netstorm.boost.edge.core.Edge;

public interface BadClassStatic extends Edge {
    Class<?> forClassName(String name); // method should not match
}
