package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.atom.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.FieldSpecTestUtil;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX 1665 Tidy this up.
public final class DefaultAutoRandomizer implements AutoRandomizer {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final FieldSpecTestUtil fieldSpecTestUtil = new DefaultFieldSpecTestUtil();
    private final UsesMocks testCase;

    public DefaultAutoRandomizer(UsesMocks useMocks) {
        this.testCase = useMocks;
    }

    // FIX BREADCRUMB 1665 -100000 Hard to read.
    public void randomizePrimitivesAndStrings(Field[] fields) {
        FieldSpec[] eligibleFields = getFieldsToRandomize(fields);
        Object[] randomInstances = fieldSpecTestUtil.getInstances(eligibleFields);
        for (int i = 0; i < eligibleFields.length; i++) {
            FieldSpec primitiveField = eligibleFields[i];
            Object randomValue = randomInstances[i];
            fielder.setInstance(testCase, primitiveField.getName(), randomValue);
        }
    }

    private FieldSpec[] getFieldsToRandomize(Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            addIfRandomizable(fields[i], result);
        }
        return (FieldSpec[]) result.toArray(new FieldSpec[]{});
    }

    private void addIfRandomizable(Field field, Set result) {
        Class fieldType = field.getType();
        String fieldName = field.getName();
        if (!isFieldRandomizable(fieldType))
            return;
        if (isFieldSet(field))
            return;
        addFieldToSet(fieldName, fieldType, result);
    }

    private boolean isFieldSet(Field field) {
        Object ref = fielder.getInstance(testCase, field);
        return ref != null;
    }

    private void addFieldToSet(String fieldName, Class fieldType, Set fieldSpecSet) {
        FieldSpec fieldSpec = new DefaultFieldSpec(fieldName, fieldType);
        fieldSpecSet.add(fieldSpec);
    }

    private boolean isFieldRandomizable(Class fieldType) {
        return primitiveBoxer.isPrimitive(fieldType) || fieldType.equals(String.class);
    }
}
