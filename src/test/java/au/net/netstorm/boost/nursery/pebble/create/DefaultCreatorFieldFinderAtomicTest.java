package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import junit.framework.TestCase;

// FIX 1665 Do we need to call this something else.  It is not atomic.
public final class DefaultCreatorFieldFinderAtomicTest extends TestCase {
    private Fred object = new Fred();
    private CreatorFieldFinder subject = new DefaultCreatorFieldFinder();

    public void testFinder() {
        Field[] expectedFields = createExpectedCreatorFields();
        CreatorField[] actualFields = subject.find(object);
        checkFields(expectedFields, actualFields);
    }

    private Field[] createExpectedCreatorFields() {
        Field[] fields = new Field[2];
        fields[0] = getField("newTed");
        fields[1] = getField("newNed");
        return fields;
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
