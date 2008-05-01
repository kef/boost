package au.net.netstorm.boost.nursery.autoedge.testdata.java.lang;

import au.net.netstorm.boost.nursery.autoedge.StaticEdge;

public interface ClassStatic extends StaticEdge<Class<?>> {
    Class<?> forName(String name);
}
