package au.net.netstorm.boost.pebble.create.field;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.pebble.create.core.DoesNotImplementCreatorException;
import au.net.netstorm.boost.pebble.create.fixture.DefaultNed;
import au.net.netstorm.boost.pebble.create.fixture.Fred;
import au.net.netstorm.boost.pebble.create.fixture.FredWithBrokenCreator;
import au.net.netstorm.boost.pebble.create.fixture.NewDefaultNed;
import au.net.netstorm.boost.pebble.create.fixture.NewTedImpl;
import au.net.netstorm.boost.pebble.create.fixture.TedImpl;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultCreatorFieldFinderAtomicTest extends TestCase {
    private CreatorFieldFinder subject = new DefaultCreatorFieldFinder();
    private Fred object = new Fred();
    private FredWithBrokenCreator objectWithBrokenCreator = new FredWithBrokenCreator();

    public void testFinder() {
        CreatorField[] expected = createExpectedCreatorFields();
        CreatorField[] actual = subject.find(object);
        checkFields(expected, actual);
    }

    public void testFieldMustImplementCreator() {
        try {
            subject.find(objectWithBrokenCreator);
            fail();
        } catch (DoesNotImplementCreatorException expected) { }
    }

    private CreatorField[] createExpectedCreatorFields() {
        List result = new ArrayList();
        addCreatorField(result, NewTedImpl.class, TedImpl.class, "newTedImpl");
        addCreatorField(result, NewDefaultNed.class, DefaultNed.class, "newDefaultNed");
        return (CreatorField[]) result.toArray(new CreatorField[]{});
    }

    private void addCreatorField(List result, Class creatorInterface, Class instanceImplementation, String fieldName) {
        Interface iface = new DefaultInterface(creatorInterface);
        CreatorField tedCreatorField = new DefaultCreatorField(iface, instanceImplementation, fieldName);
        result.add(tedCreatorField);
    }

    // FIX 1715 AssertHelper does this.
    private void checkFields(CreatorField[] expected, CreatorField[] actual) {
        checkFieldCount(expected, actual);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    private void checkFieldCount(CreatorField[] expected, CreatorField[] actual) {
        int expectedLength = expected.length;
        int actualLength = actual.length;
        assertEquals(expectedLength, actualLength);
    }
}
