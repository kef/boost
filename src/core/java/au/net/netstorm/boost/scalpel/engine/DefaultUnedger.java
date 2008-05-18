package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.scalpel.core.Edge;
import au.net.netstorm.boost.scalpel.core.Unedgable;

final class DefaultUnedger implements Unedger {
    EdgeMapper mapper;

    public Object[] unedge(Object[] edged) {
        if (edged == null) return edged;
        Object[] real = new Object[edged.length];
        for (int i = 0; i < edged.length; ++i) {
            real[i] = unedge(edged[i]);
        }
        return real;
    }

    public Class<?>[] unedge(Class<?>[] edged) {
        Class<?>[] real = new Class<?>[edged.length];
        for (int i = 0; i < edged.length; ++i) {
            real[i] = unedge(edged[i]);
        }
        return real;
    }

    private Object unedge(Object candidate) {
        if (!(candidate instanceof Unedgable)) return candidate;
        Unedgable edge = (Unedgable) candidate;
        return edge.unedge();
    }

    public Class<?> unedge(Class<?> candidate) {
        if (!Edge.class.isAssignableFrom(candidate)) return candidate;
        return mapper.edgeToReal(candidate);
    }
}
