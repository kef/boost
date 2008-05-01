package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

interface MethodWarp {
    Method warp(Class<?> real, Method edge);
}
