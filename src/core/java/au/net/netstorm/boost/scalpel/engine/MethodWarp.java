package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

interface MethodWarp {
    Method warp(Class<?> real, Method edge);
}
