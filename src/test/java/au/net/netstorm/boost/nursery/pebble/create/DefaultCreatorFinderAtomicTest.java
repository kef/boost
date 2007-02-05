package au.net.netstorm.boost.nursery.pebble.create;

import junit.framework.TestCase;

public final class DefaultCreatorFinderAtomicTest extends TestCase {
    private Fred object = new Fred();

    public void testFinder() {
        CreatorFieldFinder fieldFinder = new DefaultCreatorFieldFinder();
        CreatorField[] creatorfields = fieldFinder.find(object);

    }

    private class NewTed {}
    private class NewNed {}

    private class Fred {
        private NewTed newTed;
        private NewNed newNed;
        private String notACretorField;

    }

}
