package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.reflect.ClassMorpher;
import au.net.netstorm.boost.reflect.DefaultClassMorpher;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX DEBT ClassDataAbstractionCoupling {
public final class DefaultFieldInspector implements FieldInspector {
    private static final Class CREATOR_MARKER_INTERFACE = Newer.class;
    // FIX 1665 Should be passed in via the constructor.
    private ClassMorpher classMorpher = new DefaultClassMorpher();
    private final EdgeField edgeField = new DefaultEdgeField();

    public void creatorFieldChecker(Object ref, Field declaredField, Set creatorFields) {
        if (isCreator(ref, declaredField)) {
            addCreator(creatorFields, declaredField);
        }
    }

    private void addCreator(Set creatorFields, Field declaredField) {
        Class fieldType = declaredField.getType();
        Interface creatorInterface = new DefaultInterface(fieldType);
        Class instanceImplementation = classMorpher.stripPrefix("New", fieldType);
        String fieldName = declaredField.getName();
        CreatorField creatorField = new DefaultCreatorField(creatorInterface, instanceImplementation, fieldName);
        creatorFields.add(creatorField);
    }

    // FIX 1665 Barf if CreatorInterface does not contain IMPLEMENTATION field?
    private boolean isCreator(Object ref, Field field) {
        if (isFinal(field)) return false;
        if (isSet(ref, field)) return false;
        if (!nameStartsWith(field, "new")) return false;
        checkImplementsMarker(field);
        return true;
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
// } DEBT ClassDataAbstractionCoupling