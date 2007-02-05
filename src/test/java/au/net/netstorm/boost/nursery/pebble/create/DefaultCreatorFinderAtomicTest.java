package au.net.netstorm.boost.nursery.pebble.create;

import junit.framework.TestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorFinderAtomicTest extends TestCase {
    private Interface object;

    public void testFinder() {
        CreatorFieldFinder fieldFinder = new DefaultCreatorFieldFinder();
        DefaultCreatorField[] creatorfields = fieldFinder.find(object);
    }

}
