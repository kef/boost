package au.net.netstorm.boost.pebble.inject.resolver.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.test.automock.BoooostTestCase;

public final class DefaultResolverFieldFinderAtomicTest extends BoooostTestCase {
    private ResolverFieldFinder subject = new DefaultResolverFieldFinder();
    private Pebble pebble = new Legend();

    // FIX 1715 Complete this test.
    // FIX 1715 Ensure we get only two fields from the field finder.
    // FIX 1715 Check the others did not get modified.
    public void testFind() {
        Field[] fields = subject.find(pebble);
        int length = fields.length;
        assertEquals(2, length);
    }
}
