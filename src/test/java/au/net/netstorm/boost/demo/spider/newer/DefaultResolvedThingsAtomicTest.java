package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolvedThingsAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    ResolvedThings subject;
    Implementation impl;
    BaseReference expected;
    Implementation doesNotExist;
    BaseReference ref;

    public void setupSubjects() {
        subject = new DefaultResolvedThings();
    }

    // FIX BREADCRUMB 1971 Refactor this bad boy.
    public void testExists() {
        checkPut(impl, expected);
        boolean actual = subject.exists(impl);
        assertEquals(true, actual);
    }

    public void testPutSuccess() {
        checkPut(impl, expected);
    }

    public void testPutFailure() {
        subject.put(impl, expected);
        try {
            subject.get(doesNotExist);
            fail();
        } catch (IllegalStateException expected) { }
    }

    private void checkPut(Implementation implementation, BaseReference baseReference) {
        subject.put(implementation, baseReference);
        ResolvedInstance actual = subject.get(impl);
        assertEquals(expected, actual);
    }
}
