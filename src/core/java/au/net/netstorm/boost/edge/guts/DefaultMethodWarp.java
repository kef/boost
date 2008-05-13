package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

final class DefaultMethodWarp implements MethodWarp {
    EdgeClass classer;
    Unedger unedger;

    public Method warp(Class<?> real, Method edge) {
        String name = edge.getName();
        Class<?>[] edgeParams = edge.getParameterTypes();
        Class<?>[] realParams = unedger.unedge(edgeParams);
        return classer.getMethod(real, name, realParams);
    }
}
