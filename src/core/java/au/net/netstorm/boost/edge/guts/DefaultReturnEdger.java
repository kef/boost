package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.edge.core.Edge;

final class DefaultReturnEdger implements ReturnEdger {
    AutoEdger edger;

    public Object edge(Method edgeMethod, Object realReturn) {
        Class<?> type = edgeMethod.getReturnType();
        if (!Edge.class.isAssignableFrom(type)) return realReturn;
        return edger.edge(type, realReturn);
    }
}
