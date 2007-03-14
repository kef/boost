package au.net.netstorm.boost.pebble.inject.resolver.field;

import au.net.netstorm.boost.test.automock.BoooostTestCase;

public final class DefaultResolverFieldFinderAtomicTest extends BoooostTestCase {
    private ResolverFieldFinder subject;

    // FIX BREADCRUMB 1715 Return here.
    public void testSubject() {
        subject = new DefaultResolverFieldFinder();
    }
}
