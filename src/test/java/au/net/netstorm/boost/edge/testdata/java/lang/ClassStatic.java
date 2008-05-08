package au.net.netstorm.boost.edge.testdata.java.lang;

import au.net.netstorm.boost.edge.StaticEdge;

public interface ClassStatic extends StaticEdge<Class<?>> {
    Class<?> forName(String name);
}
