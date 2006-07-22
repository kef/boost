package au.net.netstorm.boost.java.lang.reflect;

import java.lang.reflect.Constructor;

public interface EdgeConstructor {
    EdgeConstructor EDGE_CONSTRUCTOR = new DefaultEdgeConstructor();

    void newInstance(Constructor constructor, Object[] initArgs);
}
