package au.net.netstorm.boost.nursery.pebble.create;

import java.util.Random;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxyInjector subject;
    private MockExpectations expect;
    private Object object = new Larry("ten");
    private Object proxy = "nine";
    private CreatorField[] creatorFields = {}; // FIX 1665 This flushes out the need to deal with arrays differently.
    private CreatorProxySupplier creatorProxySupplier;
    private CreatorFieldFinder creatorFieldFinder;
    private CreatorField creatorField;
    private Interface creatorInterface;
    private String fieldName = "fingers";
    private Class instanceImplementation = Random.class;
    private Object expectedLarry = new Larry("nine");
    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();

    public void setupSubjects() {
        subject = new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);
        creatorFields = new CreatorField[]{creatorField, creatorField};
    }

    public void testSubject() {
        expect.oneCall(creatorFieldFinder, creatorFields, "find", object);
        setArrayElementExpectations();
        subject.inject(object);
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
