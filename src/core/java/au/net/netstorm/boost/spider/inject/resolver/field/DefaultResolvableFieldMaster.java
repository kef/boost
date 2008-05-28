package au.net.netstorm.boost.spider.inject.resolver.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeField;

public final class DefaultResolvableFieldMaster implements ResolvableFieldMaster {
    private final EdgeField fielder = new DefaultEdgeField();
    
    public boolean isResolvableField(Object ref, Field field) {
        field.setAccessible(true);
        return isResolvableField(field) && isNull(ref, field);
    }

    public boolean isResolvableField(Field field) {
        field.setAccessible(true);
        return !isStatic(field) && !isFinal(field) && !isPrivate(field);
    }

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
}
