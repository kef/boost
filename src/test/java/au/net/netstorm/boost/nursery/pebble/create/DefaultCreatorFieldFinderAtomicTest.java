package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import junit.framework.TestCase;

public final class DefaultCreatorFieldFinderAtomicTest extends TestCase {
    private Fred object = new Fred();
    private CreatorFieldFinder subject = new DefaultCreatorFieldFinder();
    private EdgeClass edgeClass = new DefaultEdgeClass();

    public void testFinder() {
        Field[] expectedFields = createExpectedCreatorFields();
        CreatorField[] actualFields = subject.find(object);
        checkFields(expectedFields, actualFields);
    }

    private Field[] createExpectedCreatorFields() {
        Field[] fields = new Field[2];
        fields[0] = getField("newTedCreator");
        fields[1] = getField("newNedCreator");
        return fields;
    }

    private Field getField(String fieldName) {
        Class type = object.getClass();
        return edgeClass.getDeclaredField(type, fieldName);
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
        Class expectedType = expectedField.getType();
        Class creatorType = actualCreatorField.getCreatorType();
        assertEquals(expectedType, creatorType);
    }
}
