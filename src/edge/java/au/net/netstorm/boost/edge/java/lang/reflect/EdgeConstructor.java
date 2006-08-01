package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;

public interface EdgeConstructor {
    Object newInstance(Constructor constructor, Object[] parameters);
}
