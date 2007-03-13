package au.net.netstorm.boost.pebble.newer.inject;

import java.util.Random;
import au.net.netstorm.boost.pebble.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.newer.field.NewerField;
import au.net.netstorm.boost.pebble.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.newer.fixture.Larry;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerProxyInjectorAtomicTest extends InteractionTestCase {
    private Injector subject;
    private MockExpectations expect;
    private Object object = new Larry("ten");
    private String proxy;
    private NewerField[] newerFields =
            {}; // SUGGEST: Put CARD into boost.  This flushes out the need to deal with arrays differently.
    private NewerProxySupplier newerProxySupplier;
    private NewerFieldFinder newerFieldFinder;
    private NewerField newerField;
    private Interface newerInterface;
    private String fieldName = "fingers";
    private Class instanceImplementation = Random.class;

    public void setupSubjects() {
        subject = new NewerProxyInjector(newerProxySupplier, newerFieldFinder);
        newerFields = new NewerField[]{newerField, newerField};
    }

    public void testSubject() {
        expect.oneCall(newerFieldFinder, newerFields, "find", object);
        setArrayElementExpectations();
        subject.inject(object);
        Object expectedLarry = new Larry(proxy);
        assertEquals(expectedLarry, object);
    }

    private void setArrayElementExpectations() {
        for (int i = 0; i < newerFields.length; i++) {
            expect.oneCall(newerField, newerInterface, "getNewerInterface");
            expect.oneCall(newerField, instanceImplementation, "getInstanceImplementation");
            expect.oneCall(newerProxySupplier, proxy, "nu", newerInterface, instanceImplementation);
            expect.oneCall(newerField, fieldName, "getFieldName");
        }
    }
}
