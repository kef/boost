package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.edge.core.Edge;

final class DefaultReturnEdger implements ReturnEdger {
    AutoEdger edger;

    @SuppressWarnings("unchecked")
    public Object edge(Method edgeMethod, Object realReturn) {
        Class<?> realType = edgeMethod.getReturnType();
        if (!Edge.class.isAssignableFrom(realType)) return realReturn;
        Class<Edge> edgeType = (Class<Edge>) realType;
        return edger.edge(edgeType, realReturn);
    }
}
