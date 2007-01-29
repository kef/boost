package au.net.netstorm.boost.demo.pebble;

import java.util.HashSet;
import java.util.Set;
import junit.framework.TestCase;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultCreatorAtomicTest extends TestCase {
    private static final Interface SET_INTERFACE = new DefaultInterface(Set.class);
    private static final Class SET_IMPL = HashSet.class;
    private static final Implementation SET_IMPLEMENTATION = new DefaultImplementation(SET_INTERFACE, SET_IMPL);

    public void testCreator() {
        Creator creator = new DefaultCreator(SET_IMPLEMENTATION);
        // FIX BREADCRUMB 1665 -10000 Pass in an implementation reference.
    }
}
