package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;

public interface EdgeConstructor {
    EdgeConstructor EDGE_CONSTRUCTOR = new DefaultEdgeConstructor();

    Object newInstance(Constructor constructor, Object[] initArgs);
}
