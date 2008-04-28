package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

public interface MethodWarp {
    Method warp(Class<?> clazz, Method src);
}
