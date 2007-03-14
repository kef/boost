package au.net.netstorm.boost.pebble.inject.resolver.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;

public final class DefaultResolverFieldFinder implements ResolverFieldFinder {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final EdgeField fielder = new DefaultEdgeField();

    // FIX 1715 Tidy this rot up.  Too complex.
    public Field[] find(Object ref) {
        Class cls = ref.getClass();
        Field[] fields = classer.getDeclaredFields(cls);
        List result = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            optionallyAdd(result, ref, fields[i]);
        }
        return (Field[]) result.toArray(new Field[]{});
    }

    private void optionallyAdd(List result, Object ref, Field field) {
        field.setAccessible(true);
        if (!isNull(ref, field)) return;
        if (isFinal(field)) return;
        result.add(field);
    }

    private boolean isNull(Object ref, Field field) {
        return fielder.get(field, ref) == null;
    }

    private boolean isFinal(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isFinal(modifiers);
    }
}
