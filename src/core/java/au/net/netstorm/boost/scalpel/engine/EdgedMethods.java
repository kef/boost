package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;

// FIX 2328 wire into DefaultAutoEdge
interface EdgedMethods {
    Method lookup(Method edge);
}
