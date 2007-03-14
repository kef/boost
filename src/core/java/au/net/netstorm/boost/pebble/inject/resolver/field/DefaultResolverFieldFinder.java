package au.net.netstorm.boost.pebble.inject.resolver.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultResolverFieldFinder implements ResolverFieldFinder {
    private final EdgeClass classer = new DefaultEdgeClass();

    public Field[] find(Object ref) {
        Class cls = ref.getClass();
        Field[] fields = classer.getDeclaredFields(cls);
        return fields;
    }
}
