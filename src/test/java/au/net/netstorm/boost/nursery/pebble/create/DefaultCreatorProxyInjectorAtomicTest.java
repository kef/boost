package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Remove jMock.
public final class DefaultCreatorProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxyInjector subject;
    private MockExpectations expect;
    private Object object = new Object();
    private Object proxy = new Object();
    private CreatorField[] creatorFields = {}; // FIX 1665 This flushes out the need to deal with arrays differently.
    private CreatorProxySupplier creatorProxySupplier;
    private CreatorFieldFinder creatorFieldFinder;
    private CreatorField creatorField;
    private Interface creatorInterface;

    public void setupSubjects() {
        subject = new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);
        creatorFields = new CreatorField[]{creatorField, creatorField};
    }

    public void testSubject() {
        expect.oneCall(creatorFieldFinder, creatorFields, "find", object);
        setArrayElementExpectations();
        subject.inject(object);
    }

    private void setArrayElementExpectations() {
        for (int i = 0; i < creatorFields.length; i++) {
            expect.oneCall(creatorField, creatorInterface, "getCreatorInterface");
            expect.oneCall(creatorProxySupplier, proxy, "create", creatorInterface);
        }
    }
}
