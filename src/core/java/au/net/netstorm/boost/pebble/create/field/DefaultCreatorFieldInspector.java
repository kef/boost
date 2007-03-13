package au.net.netstorm.boost.pebble.create.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.create.core.Creator;
import au.net.netstorm.boost.pebble.create.core.DoesNotImplementCreatorException;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Do we use this any more.  Yes.  Rename and tidy up
public final class DefaultCreatorFieldInspector implements CreatorFieldInspector {
    private static final Class CREATOR_MARKER_INTERFACE = Creator.class;
    // FIX 1665 Should be passed in via the constructor.
    private final EdgeField edgeField = new DefaultEdgeField();
    private final EdgeClass edgeClass = new DefaultEdgeClass();

    // FIX 1665 Barf if CreatorInterface does not contain IMPLEMENTATION field?
    public boolean isCreator(Object ref, Field field) {
        if (isFinal(field)) return false;
        if (!isNull(field, ref)) return false;
        if (!nameStartsWith(field, "new")) return false;
        checkImplementsMarker(field);
        return true;
    }

    // FIX 1665 To thick and fat.
    public CreatorField getCreator(Object ref, Field field) {
        if (!isCreator(ref, field)) throw new IllegalStateException("Not a creator field");
        return doGetCreator(field, ref);
    }

    private CreatorField doGetCreator(Field field, Object ref) {
        Class creatorCls = field.getType();
        Interface creatorType = new DefaultInterface(creatorCls);
        Class creationImpl = getClassToCreate(creatorCls, ref);
        String fieldName = field.getName();
        return new DefaultCreatorField(creatorType, creationImpl, fieldName);
    }

    private Class getClassToCreate(Class creatorType, Object ref) {
        Field implField = edgeClass.getDeclaredField(creatorType, "IMPLEMENTATION");
        implField.setAccessible(true);
        return (Class) edgeField.get(implField, ref);
    }

    private void checkImplementsMarker(Field field) {
        Class type = field.getType();
        if (!CREATOR_MARKER_INTERFACE.isAssignableFrom(type)) {
            throw new DoesNotImplementCreatorException(type);
        }
    }

    private boolean nameStartsWith(Field field, String prefix) {
        String name = field.getName();
        return name.startsWith(prefix);
    }

    private boolean isNull(Field field, Object ref) {
        field.setAccessible(true);
        Object value = edgeField.get(field, ref);
        return value == null;
    }

    private boolean isFinal(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isFinal(modifiers);
    }
}