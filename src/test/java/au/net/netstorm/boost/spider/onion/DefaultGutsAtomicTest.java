package au.net.netstorm.boost.spider.onion;

import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultGutsAtomicTest extends InteractionTestCase {
    Guts subject;
    Set guts = new HashSet();

    public void setupSubjects() {
        subject = new DefaultGuts(guts);
    }

    // FIX 1936 Complete.
    public void testSubject() {
    }
}
