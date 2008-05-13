package au.net.netstorm.boost.scalpel.testdata.java.lang;

import au.net.netstorm.boost.scalpel.core.Edge;

public interface BadClassStatic extends Edge {
    Class<?> forClassName(String name); // method should not match
}
