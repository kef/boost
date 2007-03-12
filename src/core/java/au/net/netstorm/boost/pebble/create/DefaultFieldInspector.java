package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Do we use this any more.  Yes.  Rename and tidy up
public final class DefaultFieldInspector implements FieldInspector {
    private static final Class CREATOR_MARKER_INTERFACE = Newer.class;
    // FIX 1665 Should be passed in via the constructor.
    private final EdgeField edgeField = new DefaultEdgeField();
    private final EdgeClass edgeClass = new DefaultEdgeClass();

    public void creatorFieldChecker(Set result, Object ref, Field declaredField) {
        if (isCreator(ref, declaredField)) {
            addCreator(result, declaredField, ref);
        }
    }

    // FIX 1665 Barf if CreatorInterface does not contain IMPLEMENTATION field?
    public boolean isCreator(Object ref, Field field) {
        if (isFinal(field)) return false;
        if (isSet(ref, field)) return false;
        if (!nameStartsWith(field, "new")) return false;
        checkImplementsMarker(field);
        return true;
    }

    // FIX 1665 To thick and fat.
    public void addCreator(Set creatorFields, Field declaredField, Object ref) {
        Class fieldType = declaredField.getType();
        Interface creatorInterface = new DefaultInterface(fieldType);
        String fieldName = declaredField.getName();
        Field implementationField = edgeClass.getDeclaredField(fieldType, "IMPLEMENTATION");
        implementationField.setAccessible(true);
        Class instanceImplementation = (Class) edgeField.get(implementationField, ref);
        CreatorField creatorField = new DefaultCreatorField(creatorInterface, instanceImplementation, fieldName);
        creatorFields.add(creatorField);
    }

    private void checkImplementsMarker(Field field) {
        Class type = field.getType();
        if (!CREATOR_MARKER_INTERFACE.isAssignableFrom(type)) {
            throw new DoesNotImplementNewerException(type);
        }
    }

    private boolean nameStartsWith(Field field, String prefix) {
        String name = field.getName();
        return name.startsWith(prefix);
    }

    private boolean isSet(Object ref, Field field) {
        // FIX BREADCRUMB 33203 Do we really want to do this here?
        field.setAccessible(true);
        // FIX BREADCRUMB 33203 Why not have a containsValue?
        Object value = edgeField.get(field, ref);
        return value != null;
    }

    private boolean isFinal(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isFinal(modifiers);
    }
}