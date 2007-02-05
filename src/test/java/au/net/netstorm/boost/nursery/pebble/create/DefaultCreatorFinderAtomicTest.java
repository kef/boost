package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import junit.framework.TestCase;

public final class DefaultCreatorFinderAtomicTest extends TestCase {
    private Fred object = new Fred();

    public void testFinder() {
        CreatorFieldFinder fieldFinder = new DefaultCreatorFieldFinder();
        Field[] expectedFields = createExpectedCreatorFields();
        CreatorField[] actualFields = fieldFinder.find(object);
        checkFields(expectedFields, actualFields);
    }

    // FIX 1665 Fix this
    private Field[] createExpectedCreatorFields() {
        return object.getClass().getDeclaredFields();
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
        try {
            Field expectedField = object.getClass().getDeclaredField(actualName);
            assertEquals(expectedField.getType(), actualCreatorField.getCreatorType());
        } catch (NoSuchFieldException e) {
            fail("Expected list to contain a field called " + actualName);
        }
    }
}
