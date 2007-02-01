package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplierAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxySupplier subject;
    private MockExpectations expect;
    private Interface type;

    public void setupSubjects() {
        subject = new DefaultCreatorProxySupplier();
    }

    // FIX 1665 Do more here
    public void testCreate() {
        assertNull(subject.create(type));
    }
}
