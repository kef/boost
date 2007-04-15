package au.net.netstorm.boost.spider.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class AlreadyRegisteredExceptionAtomicTest extends InteractionTestCase {
    Interface iface;
    AlreadyRegisteredException subject;

    public void setupSubjects() {
        subject = new AlreadyRegisteredException(iface);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals(iface + " already registered.", result);
    }
}
