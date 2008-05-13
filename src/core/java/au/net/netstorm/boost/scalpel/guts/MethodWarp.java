package au.net.netstorm.boost.scalpel.guts;

import java.lang.reflect.Method;

interface MethodWarp {
    Method warp(Class<?> real, Method edge);
}
