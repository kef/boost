package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultCreatorProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxyInjector subject;
    private MockExpectations expect;

    public void setupSubjects() {
        subject = new DefaultCreatorProxyInjector();
    }

    public void testInject() {
        Object object = new Object();
        subject.inject(object);
    }
}
