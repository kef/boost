package demo.edge.java.lang;

import au.net.netstorm.boost.edge.core.StaticEdge;

public interface ClassStatic extends StaticEdge<java.lang.Class<?>> {
    Class<?> forName(String name);
}
