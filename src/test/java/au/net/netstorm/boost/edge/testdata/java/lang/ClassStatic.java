package au.net.netstorm.boost.edge.testdata.java.lang;

import au.net.netstorm.boost.edge.StaticEdge;
//FIX 2328 swap over to just use edge classes from demo tree
public interface ClassStatic extends StaticEdge<Class<?>> {
    Class<?> forName(String name);
}
