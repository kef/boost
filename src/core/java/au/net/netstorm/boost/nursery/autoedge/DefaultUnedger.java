package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;

final class DefaultUnedger implements Unedger {
    TypeTokenResolver typeResolver;

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
        TypeTokenInstance typeToken = typeResolver.resolve(Edge.class, candidate);
        return typeToken.rawType();
    }
}
