package au.net.netstorm.boost.nursery.autoedge.utils;


import java.lang.reflect.Constructor;

public interface ConstructorResolver {
    <T> Constructor<T> resolve(Class<T> type, Object... params);
}
