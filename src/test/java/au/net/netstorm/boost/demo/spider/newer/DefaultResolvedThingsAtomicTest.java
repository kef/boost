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

    public void setupSubjects() {
        subject = new DefaultResolvedThings();
    }

    public void testExists() {
        checkExists(impl, false);
        checkPut(impl, expected);
        checkExists(impl, true);
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

    private void checkExists(Implementation myimpl, boolean myexpected) {
        boolean actual = subject.exists(myimpl);
        assertEquals(myexpected, actual);
    }

    private void checkPut(Implementation implementation, BaseReference baseReference) {
        subject.put(implementation, baseReference);
        ResolvedInstance actual = subject.get(impl);
        assertEquals(expected, actual);
    }
}
