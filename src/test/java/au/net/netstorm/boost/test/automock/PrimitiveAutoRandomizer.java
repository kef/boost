package au.net.netstorm.boost.test.automock;

import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.atom.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.atom.FieldSpecTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class PrimitiveAutoRandomizer implements AutoRandomizer {
    private final FieldSpecTestUtil fieldSpecTestUtil = new DefaultFieldSpecTestUtil();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final UsesMocks testCase;

    public PrimitiveAutoRandomizer(UsesMocks useMocks) {
        this.testCase = useMocks;
    }

    public void randomize(BoostField[] fields) {
        FieldSpec[] randomizableFields = getFieldsToRandomize(fields);
        randomize(randomizableFields);
    }

    private void randomize(FieldSpec[] fields) {
        Object[] randomInstances = fieldSpecTestUtil.getInstances(fields);
        for (int i = 0; i < fields.length; i++) {
            FieldSpec primitiveField = fields[i];
            Object randomValue = randomInstances[i];
            assignRandomValue(primitiveField, randomValue);
        }
    }

    private void assignRandomValue(FieldSpec fieldSpec, Object randomValue) {
        String fieldName = fieldSpec.getName();
        fielder.setInstance(testCase, fieldName, randomValue);
    }

    private FieldSpec[] getFieldsToRandomize(BoostField[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            addIfRandomizable(fields[i], result);
        }
        return (FieldSpec[]) result.toArray(new FieldSpec[]{});
    }

    private void addIfRandomizable(BoostField field, Set result) {
        String name = field.getName();
        Class type = field.getType();
        if (field.isRandomizable()) addFieldToSet(name, type, result);
    }

    private void addFieldToSet(String fieldName, Class fieldType, Set fieldSpecSet) {
        FieldSpec fieldSpec = new DefaultFieldSpec(fieldName, fieldType);
        fieldSpecSet.add(fieldSpec);
    }
}
