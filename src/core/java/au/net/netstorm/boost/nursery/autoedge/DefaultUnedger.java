package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;

final class DefaultUnedger implements Unedger {
    TypeResolver typeResolver;

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
        if (!(candidate instanceof Edge)) return candidate;
        Edge<?> edge = (Edge<?>) candidate;
        return edge.unedge();
    }

    private Class<?> unedge(Class<?> candidate) {
        if (!Edge.class.isAssignableFrom(candidate)) return candidate;
        TypeInstance typeToken = typeResolver.resolve(candidate, Edge.class, StaticEdge.class);
        return typeToken.raw();
    }
}
