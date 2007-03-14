package au.net.netstorm.boost.pebble.inject.resolver.field;

import au.net.netstorm.boost.test.automock.BoooostTestCase;

public final class DefaultResolverFieldFinderAtomicTest extends BoooostTestCase {
    private ResolverFieldFinder subject;

    // FIX 1715 Complete this test.
    // FIX 1715 Ensure we get only two fields from the field finder.
    public void testSubject() {
        subject = new DefaultResolverFieldFinder();
    }
}
