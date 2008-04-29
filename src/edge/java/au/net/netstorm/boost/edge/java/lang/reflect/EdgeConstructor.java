package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;

public interface EdgeConstructor {
    <T> T newInstance(Constructor<T> constructor, Object[] parameters);
}
