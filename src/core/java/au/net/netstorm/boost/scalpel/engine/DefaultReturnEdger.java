package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.scalpel.core.AutoEdger;
import au.net.netstorm.boost.scalpel.core.Edge;

import java.lang.reflect.Method;

final class DefaultReturnEdger implements ReturnEdger {
    AutoEdger edger;

    @SuppressWarnings("unchecked")
    public Object edge(Method edgeMethod, Object realReturn) {
        Class<?> realType = edgeMethod.getReturnType();
        // FIX 2328 realType may be an "Edge" or NOT.  Both are valid.
        // FIX 2328 if the developer (retard like me) is attempting to return
        // FIX 2328 an edge type but has mistakenly not marked the interface
        // FIX 2328 we early return with the real type.  However we know here
        // FIX 2328 that a ClassCastException will occur.
        // FIX 2328 Suggest check and barf with meaningful message.
        if (!Edge.class.isAssignableFrom(realType)) return realReturn;
        Class<Edge> edgeType = (Class<Edge>) realType;
        return edger.edge(edgeType, realReturn);
    }
}
