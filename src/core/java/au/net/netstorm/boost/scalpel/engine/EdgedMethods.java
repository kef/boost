package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

// FIX 2328 wire into DefaultAutoEdge
interface EdgedMethods {
    Method lookup(Method edge);
}
