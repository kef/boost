package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.reflect.ClassMaster;

public final class DefaultCreatorFieldFinderAtomicTest extends PrimordialTestCase implements UsesMocks {
    private Fred object = new Fred();
    private CreatorFieldFinder subject;
    private MockExpectations expect;
    private ClassMaster classMaster;

    public void setupSubjects() {
        subject = new DefaultCreatorFieldFinder(classMaster);
    }

    public void testFinder() {
        Field[] expectedFields = createExpectedCreatorFields();
        setupClassMasterExpectations();
        CreatorField[] actualFields = subject.find(object);
        checkFields(expectedFields, actualFields);
    }

    private void setupClassMasterExpectations() {
        expectGetShortNameCall("newTed", "NewTed");
        expectGetShortNameCall("newNed", "NewNed");
        expectGetShortNameCall("notACreatorField", "String");
    }

    private Field[] createExpectedCreatorFields() {
        Field[] fields = new Field[2];
        fields[0] = getField("newTed");
        fields[1] = getField("newNed");
        return fields;
    }

    private void expectGetShortNameCall(String fieldName, String className) {
        Field field = getField(fieldName);
        expect.oneCall(classMaster, className, "getShortName", field.getType());
    }

    private Field getField(String fieldName) {
        try {
            return object.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkFields(Field[] expectedFields, CreatorField[] actualFields) {
        assertEquals(expectedFields.length, actualFields.length);
        for (int i = 0; i < actualFields.length; i++) {
            CreatorField actualCreatorField = actualFields[i];
            String actualName = actualCreatorField.getFieldName();
            checkField(actualName, actualCreatorField);
        }
    }

    private void checkField(String actualName, CreatorField actualCreatorField) {
        Field expectedField = getField(actualName);
        assertEquals(expectedField.getType(), actualCreatorField.getCreatorType());
    }
}
