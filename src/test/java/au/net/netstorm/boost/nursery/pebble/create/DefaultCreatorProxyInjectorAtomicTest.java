package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

// FIX 1665 Remove jMock.
public final class DefaultCreatorProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxyInjector subject;
    private MockExpectations expect;
    private Object object = new Object();
    private CreatorProxySupplier creatorProxySupplier;
    private CreatorFieldFinder creatorFieldFinder;
    private CreatorField creatorField1;
    private CreatorField creatorField2;
    private CreatorField[] creatorFields = {creatorField1, creatorField2};

    public void setupSubjects() {
        subject = new DefaultCreatorProxyInjector(creatorProxySupplier, creatorFieldFinder);
    }

    public void testSubject() {
        expect.oneCall(creatorFieldFinder, creatorFields, "find", object);
        subject.inject(object);
    }
}
