package au.net.netstorm.boost.nursery.pebble.create;

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
    private OldCreatorField[] creatorFields = {}; // FIX 1665 This flushes out the need to deal with arrays differently.
    private CreatorProxySupplier creatorProxySupplier;
    private CreatorFieldFinder creatorFieldFinder;
    private OldCreatorField creatorField;
    private Interface creatorInterface;
    private String fieldName = "fingers";
    private Object expectedLarry = new Larry("nine");

    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();

    public void setupSubjects() {
        subject = new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);
        creatorFields = new OldCreatorField[]{creatorField, creatorField};
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
            expect.oneCall(creatorProxySupplier, proxy, "create", creatorInterface);
            expect.oneCall(creatorField, fieldName, "getFieldName");
        }
    }
}
