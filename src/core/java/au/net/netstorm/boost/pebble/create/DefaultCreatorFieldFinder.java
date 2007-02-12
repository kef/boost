package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.reflect.ClassMorpher;
import au.net.netstorm.boost.reflect.DefaultClassMorpher;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Sort this coupling out.
// FIX 1665 Split this based on field.  Have a single CreatorFieldChecker (or something).

// DEBT ClassDataAbstractionCoupling {
public final class DefaultCreatorFieldFinder implements CreatorFieldFinder {
    private static final Class CREATOR_MARKER_INTERFACE = Newer.class;

    private EdgeField edgeField = new DefaultEdgeField();
    // FIX 1665 Should be passed in via the constructor.
    private ClassMorpher classMorpher = new DefaultClassMorpher();

    public CreatorField[] find(Object ref) {
        Field[] declaredFields = getDeclaredFields(ref);
        return find(ref, declaredFields);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class refType = ref.getClass();
        return refType.getDeclaredFields();
    }

    private CreatorField[] find(Object ref, Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            find(result, ref, fields[i]);
        }
        return (CreatorField[]) result.toArray(new CreatorField[]{});
    }

    private void find(Set result, Object ref, Field field) {
        if (isCreator(ref, field))
            addCreator(result, field);
    }

    // FIX 1665 Barf if CreatorInterface does not contain IMPLEMENTATION field?
    private boolean isCreator(Object ref, Field field) {
        if (isFinal(field)) return false;
        if (isSet(ref, field)) return false;
        if (!nameStartsWith(field, "new")) return false;
        // FIX BREADCRUMB 1665 Add check for field type?
        checkImplementsMarker(field);
        return true;
    }

    private void checkImplementsMarker(Field field) {
        Class type = field.getType();
        if (!CREATOR_MARKER_INTERFACE.isAssignableFrom(type)) {
            throw new DoesNotImplementNewerException(type);
        }
    }

    private boolean isFinal(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isFinal(modifiers);
    }

    private boolean isSet(Object ref, Field field) {
        field.setAccessible(true);
        Object value = edgeField.get(field, ref);
        return value != null;
    }

    private boolean nameStartsWith(Field field, String prefix) {
        String name = field.getName();
        return name.startsWith(prefix);
    }

    private void addCreator(Set creatorFields, Field field) {
        Class fieldType = field.getType();
        Interface creatorInterface = new DefaultInterface(fieldType);
        Class instanceImplementation = classMorpher.stripPrefix("New", fieldType);
        String fieldName = field.getName();
        CreatorField creatorField = new DefaultCreatorField(creatorInterface, instanceImplementation, fieldName);
        creatorFields.add(creatorField);
    }
}
// } DEBT ClassDataAbstractionCoupling
