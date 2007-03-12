package au.net.netstorm.boost.pebble.create.inject;

import java.util.Random;
import au.net.netstorm.boost.pebble.create.CreatorProxySupplier;
import au.net.netstorm.boost.pebble.create.field.CreatorFieldFinder;
import au.net.netstorm.boost.pebble.create.field.PebbleField;
import au.net.netstorm.boost.pebble.create.fixture.Larry;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private Injector subject;
    private MockExpectations expect;
    private Object object = new Larry("ten");
    private String proxy;
    private PebbleField[] creatorFields =
            {}; // SUGGEST: Put CARD into boost.  This flushes out the need to deal with arrays differently.
    private CreatorProxySupplier creatorProxySupplier;
    private CreatorFieldFinder creatorFieldFinder;
    private PebbleField creatorField;
    private Interface creatorInterface;
    private String fieldName = "fingers";
    private Class instanceImplementation = Random.class;

    public void setupSubjects() {
        subject = new CreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);
        creatorFields = new PebbleField[]{creatorField, creatorField};
    }

    public void testSubject() {
        expect.oneCall(creatorFieldFinder, creatorFields, "find", object);
        setArrayElementExpectations();
        subject.inject(object);
        Object expectedLarry = new Larry(proxy);
        assertEquals(expectedLarry, object);
    }

    private void setArrayElementExpectations() {
        for (int i = 0; i < creatorFields.length; i++) {
            expect.oneCall(creatorField, creatorInterface, "getCreatorInterface");
            expect.oneCall(creatorField, instanceImplementation, "getInstanceImplementation");
            expect.oneCall(creatorProxySupplier, proxy, "create", creatorInterface, instanceImplementation);
            expect.oneCall(creatorField, fieldName, "getFieldName");
        }
    }
}
