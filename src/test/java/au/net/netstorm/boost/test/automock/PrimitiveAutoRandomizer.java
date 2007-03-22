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
            assignRandomValue(fields[i], randomInstances[i]);
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
        // FIX 1676 This condition goes out of here.  Pass is ONLY the things to randomize.
        if (field.isNull() || field.isPrimitive()) addField(result, name, type);
    }

    private void addField(Set set, String fieldName, Class fieldType) {
        FieldSpec fieldSpec = new DefaultFieldSpec(fieldName, fieldType);
        set.add(fieldSpec);
    }
}
