package au.net.netstorm.boost.pebble.create.field;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.pebble.create.DoesNotImplementNewerException;
import au.net.netstorm.boost.pebble.create.fixture.DefaultNed;
import au.net.netstorm.boost.pebble.create.fixture.Fred;
import au.net.netstorm.boost.pebble.create.fixture.FredWithBrokenNewer;
import au.net.netstorm.boost.pebble.create.fixture.NewDefaultNed;
import au.net.netstorm.boost.pebble.create.fixture.NewTedImpl;
import au.net.netstorm.boost.pebble.create.fixture.TedImpl;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultCreatorFieldFinderAtomicTest extends TestCase {
    private CreatorFieldFinder subject = new DefaultCreatorFieldFinder();
    private Fred object = new Fred();
    private FredWithBrokenNewer objectWithBrokenNewer = new FredWithBrokenNewer();

    public void testFinder() {
        PebbleField[] expected = createExpectedCreatorFields();
        PebbleField[] actual = subject.find(object);
        checkFields(expected, actual);
    }

    public void testFieldMustImplementNewer() {
        try {
            subject.find(objectWithBrokenNewer);
            fail();
        } catch (DoesNotImplementNewerException expected) { }
    }

    private PebbleField[] createExpectedCreatorFields() {
        List result = new ArrayList();
        addCreatorField(result, NewTedImpl.class, TedImpl.class, "newTedImpl");
        addCreatorField(result, NewDefaultNed.class, DefaultNed.class, "newDefaultNed");
        return (PebbleField[]) result.toArray(new PebbleField[]{});
    }

    private void addCreatorField(List result, Class creatorInterface, Class instanceImplementation, String fieldName) {
        Interface iface = new DefaultInterface(creatorInterface);
        PebbleField tedCreatorField = new DefaultPebbleField(iface, instanceImplementation, fieldName);
        result.add(tedCreatorField);
    }

    // FIX 1715 AssertHelper does this.
    private void checkFields(PebbleField[] expected, PebbleField[] actual) {
        checkFieldCount(expected, actual);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    private void checkFieldCount(PebbleField[] expected, PebbleField[] actual) {
        int expectedLength = expected.length;
        int actualLength = actual.length;
        assertEquals(expectedLength, actualLength);
    }
}
