package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultCreatorFieldFinderAtomicTest extends TestCase {
    private Fred object = new Fred();
    private CreatorFieldFinder subject = new DefaultCreatorFieldFinder();
    private EdgeClass edgeClass = new DefaultEdgeClass();

    public void testFinder() {
        Field[] expectedFields = createExpectedCreatorFields();
        OldCreatorField[] actualFields = subject.find(object);
        checkFields(expectedFields, actualFields);
    }

    private Field[] createExpectedCreatorFields() {
        Field[] fields = new Field[2];
        fields[0] = getField("newTedCreator");
        fields[1] = getField("newNedCreator");
        return fields;
    }

    private void checkFields(Field[] expected, OldCreatorField[] actual) {
        checkFieldLength(expected, actual);
        checkFieldInterfaces(expected, actual);
    }

    private void checkFieldLength(Field[] expected, OldCreatorField[] actual) {
        int expectedLength = expected.length;
        int actualLength = actual.length;
        assertEquals(expectedLength, actualLength);
    }

    private void checkFieldInterfaces(Field[] expected, OldCreatorField[] actual) {
        for (int i = 0; i < actual.length; i++) {
            OldCreatorField creatorField = actual[i];
            checkFieldInterface(expected[i], creatorField);
        }
    }

    private void checkFieldInterface(Field expectedField, OldCreatorField actualField) {
        Interface expected = getExpectedInterface(expectedField);
        Interface actual = actualField.getCreatorInterface();
        assertEquals(expected, actual);
    }

    private Interface getExpectedInterface(Field field) {
        Class expectedClass = field.getType();
        return new DefaultInterface(expectedClass);
    }

    private Field getField(String fieldName) {
        Class type = object.getClass();
        return edgeClass.getDeclaredField(type, fieldName);
    }
}
