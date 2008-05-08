package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;

interface MethodWarp {
    Method warp(Class<?> real, Method edge);
}
