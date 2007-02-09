package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.reflect.ClassNameMorpher;
import au.net.netstorm.boost.reflect.DefaultClassNameMorpher;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Is this really debt?

// DEBT ClassDataAbstractionCoupling {
public final class DefaultCreatorFieldFinder implements CreatorFieldFinder {
    private static final Class CREATOR_MARKER_INTERFACE = Newer.class;
    private EdgeField edgeField = new DefaultEdgeField();
    private ClassNameMorpher classNameMorpher = new DefaultClassNameMorpher();

    public CreatorField[] find(Object ref) {
        Field[] declaredFields = getDeclaredFields(ref);
        return find(ref, declaredFields);
    }

    private CreatorField[] find(Object ref, Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (isCreator(ref, field)) {
                addCreator(result, field);
            }
        }
        return (CreatorField[]) result.toArray(new CreatorField[]{});
    }

    private boolean isCreator(Object ref, Field field) {
        if (isFinal(field))
            return false;
        if (isSet(ref, field))
            return false;
        if (!implementsMarker(field))
            return false;
        return nameStartsWith(field, "new");
    }

    private boolean implementsMarker(Field field) {
        Class type = field.getType();
        return CREATOR_MARKER_INTERFACE.isAssignableFrom(type);
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
        Class instanceImplementation = classNameMorpher.stripPrefix("New", fieldType);
        String fieldName = field.getName();
        CreatorField creatorField = new DefaultCreatorField(creatorInterface, instanceImplementation, fieldName);
        creatorFields.add(creatorField);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class refType = ref.getClass();
        return refType.getDeclaredFields();
    }
}
// } DEBT ClassDataAbstractionCoupling
