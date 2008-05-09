package demo.edge.java.lang;

import au.net.netstorm.boost.edge.core.StaticEdge;

public interface ClassStatic extends StaticEdge {
    Class<?> forName(String name);
}
