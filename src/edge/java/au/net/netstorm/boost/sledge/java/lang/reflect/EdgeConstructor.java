package au.net.netstorm.boost.sledge.java.lang.reflect;

import java.lang.reflect.Constructor;

public interface EdgeConstructor {
    <T> T newInstance(Constructor<T> constructor, Object[] parameters);
}
