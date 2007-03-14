package au.net.netstorm.boost.pebble.inject.resolver.field;

import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.test.automock.BoooostTestCase;

public final class DefaultResolverFieldFinderAtomicTest extends BoooostTestCase {
    private ResolverFieldFinder subject = new DefaultResolverFieldFinder();
    private Pebble ref = new Legend();

    // FIX 1715 Complete this test.
    // FIX 1715 Ensure we get only two fields from the field finder.
    // FIX 1715 Check the others did not get modified.
    public void testSubject() {
        subject.find(ref);
    }
}
