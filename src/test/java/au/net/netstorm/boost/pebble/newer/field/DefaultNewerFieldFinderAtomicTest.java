package au.net.netstorm.boost.pebble.newer.field;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.pebble.newer.core.DoesNotImplementNewerException;
import au.net.netstorm.boost.test.automock.BoooostTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerFieldFinderAtomicTest extends BoooostTestCase {

    private NewerFieldFinder subject = new DefaultNewerFieldFinder();
    private Fred object = new Fred();
    private FredWithBrokenNewer objectWithBrokenNewer = new FredWithBrokenNewer();

    public void testFinder() {
        NewerField[] expected = createExpectedNewerFields();
        NewerField[] actual = subject.find(object);
        assertEquals(expected, actual);
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
}
