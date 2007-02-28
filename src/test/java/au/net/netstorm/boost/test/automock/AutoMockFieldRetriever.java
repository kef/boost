package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;

// FIX 35593 Delete our field inspector.
public final class AutoMockFieldRetriever implements FieldRetriever {
    private final ModifierTestUtil modifiers = new DefaultModifierTestUtil();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final List arrayTypes = new ArrayList();

    public Field[] retrieve(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        return strip(ref, fields);
    }

    // SUGGEST: Can maybe be replaced with field.isSynthetic() in 1.5?
    private Field[] strip(Object ref, Field[] fields) {
        List immutable = Arrays.asList(fields);
        List result = new ArrayList(immutable);
        for (int i = 0; i < fields.length; i++) {
            examine(ref, result, fields[i]);
        }
        return (Field[]) result.toArray(new Field[]{});
    }

    // DEBT CyclomaticComplexity {
    private void examine(Object ref, List list, Field field) {
        if (isSynthetic(field)) list.remove(field);
        if (isFinal(field)) list.remove(field);
        if (!isNull(ref, field)) list.remove(field);
        if (isArray(field)) checkForDuplicateArrays(field);
    }
    // } DEBT CyclomaticComplexity

    // FIX BREADCRUMB 35593 Add bad demo test which has multiple arrays of same component type.

    private void checkForDuplicateArrays(Field field) {
        Class cls = field.getType();
        Class componentType = cls.getComponentType();
        if (arrayTypes.contains(componentType))
            throw new IllegalStateException("Duplicate array component type " + componentType + " found");
        arrayTypes.add(componentType);
    }

    private boolean isArray(Field field) {
        Class cls = field.getType();
        return cls.isArray();
    }

    private boolean isNull(Object ref, Field field) {
        return fielder.getInstance(ref, field) == null;
    }

    private boolean isFinal(Field field) {
        return modifiers.isFinal(field);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }

    private boolean isSynthetic(Field field) {
        String fieldName = field.getName();
        return fieldName.contains("$");
    }
}
