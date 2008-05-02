package au.net.netstorm.boost.nursery.autoedge.testdata.java.lang;

import au.net.netstorm.boost.nursery.autoedge.StaticEdge;
//FIX 2328 swap over to just use edge classes from demo tree
public interface ClassStatic extends StaticEdge<Class<?>> {
    Class<?> forName(String name);
}
