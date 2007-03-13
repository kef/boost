package au.net.netstorm.boost.pebble.newer.field;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.pebble.newer.core.DoesNotImplementNewerException;
import au.net.netstorm.boost.pebble.newer.fixture.DefaultNed;
import au.net.netstorm.boost.pebble.newer.fixture.Fred;
import au.net.netstorm.boost.pebble.newer.fixture.FredWithBrokenNewer;
import au.net.netstorm.boost.pebble.newer.fixture.NewDefaultNed;
import au.net.netstorm.boost.pebble.newer.fixture.NewTedImpl;
import au.net.netstorm.boost.pebble.newer.fixture.TedImpl;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultNewerFieldFinderAtomicTest extends TestCase {
    private NewerFieldFinder subject = new DefaultNewerFieldFinder();
    private Fred object = new Fred();
    private FredWithBrokenNewer objectWithBrokenNewer = new FredWithBrokenNewer();

    public void testFinder() {
        NewerField[] expected = createExpectedNewerFields();
        NewerField[] actual = subject.find(object);
        checkFields(expected, actual);
    }

    public void testFieldMustImplementNewer() {
        try {
            subject.find(objectWithBrokenNewer);
            fail();
        } catch (DoesNotImplementNewerException expected) { }
    }

    private NewerField[] createExpectedNewerFields() {
        List result = new ArrayList();
        addNewerField(result, NewTedImpl.class, TedImpl.class, "newTedImpl");
        addNewerField(result, NewDefaultNed.class, DefaultNed.class, "newDefaultNed");
        return (NewerField[]) result.toArray(new NewerField[]{});
    }

    private void addNewerField(List result, Class newerInterface, Class instanceImplementation, String fieldName) {
        Interface iface = new DefaultInterface(newerInterface);
        NewerField tedNewerField = new DefaultNewerField(iface, instanceImplementation, fieldName);
        result.add(tedNewerField);
    }

    // FIX 1715 AssertHelper does this.
    private void checkFields(NewerField[] expected, NewerField[] actual) {
        checkFieldCount(expected, actual);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    private void checkFieldCount(NewerField[] expected, NewerField[] actual) {
        int expectedLength = expected.length;
        int actualLength = actual.length;
        assertEquals(expectedLength, actualLength);
    }
}
