package au.net.netstorm.boost.gunge.reflect;


import java.lang.reflect.Constructor;

public interface ConstructorResolver {
    <T> Constructor<T> resolve(Class<T> type, Object... params);
}
