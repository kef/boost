package au.net.netstorm.boost.edge.java.lang;

import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeClassFactory implements EdgeClassFactory {
    public EdgeClass get(Class cls) {
        return new DefaultEdgeClass(cls);
    }

    public EdgeClass get(String className) {
        Class cls = forName(className);
        return new DefaultEdgeClass(cls);
    }

    private Class forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new EdgeException(e);
        }
    }
}
