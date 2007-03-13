package au.net.netstorm.boost.pebble.create.inject;

import java.util.Random;
import au.net.netstorm.boost.pebble.create.core.NewerProxySupplier;
import au.net.netstorm.boost.pebble.create.field.NewerField;
import au.net.netstorm.boost.pebble.create.field.NewerFieldFinder;
import au.net.netstorm.boost.pebble.create.fixture.Larry;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1715 Rename all fields with creator in to "newer".

// FIX 1715 Rename all creator packages to newer.
public final class DefaultNewerProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
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
            expect.oneCall(newerField, newerInterface, "getCreatorInterface");
            expect.oneCall(newerField, instanceImplementation, "getInstanceImplementation");
            expect.oneCall(newerProxySupplier, proxy, "create", newerInterface, instanceImplementation);
            expect.oneCall(newerField, fieldName, "getFieldName");
        }
    }
}
