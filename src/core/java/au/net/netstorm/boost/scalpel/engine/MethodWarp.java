package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;

interface MethodWarp {
    Method warp(Class<?> real, Method edge);
}
