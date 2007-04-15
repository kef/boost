package au.net.netstorm.boost.spider.inject.resolver.field;

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

    public Field[] find(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        List result = find(ref, fields);
        return (Field[]) result.toArray(new Field[]{});
    }

    private List find(Object ref, Field[] fields) {
        List result = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            optionallyAdd(result, ref, fields[i]);
        }
        return result;
    }

    // DEBT CyclomaticComplexity|NCSS {
    private void optionallyAdd(List result, Object ref, Field field) {
        field.setAccessible(true);
        if (isStatic(field)) return;
        if (!isNull(ref, field)) return;
        if (isFinal(field)) return;
        if (isPrivate(field)) return;
        result.add(field);
    }
    // } DEBT CyclomaticComplexity|NCSS

    private boolean isStatic(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isStatic(modifiers);
    }

    private boolean isPrivate(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isPrivate(modifiers);
    }

    private boolean isNull(Object ref, Field field) {
        return fielder.get(field, ref) == null;
    }

    private boolean isFinal(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isFinal(modifiers);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return classer.getDeclaredFields(cls);
    }
}
