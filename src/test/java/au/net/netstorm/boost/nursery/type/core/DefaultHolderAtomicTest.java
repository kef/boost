package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.test.core.BoooostCase;

// FIX BREADCRUMB  97098 Complete me.
public final class DefaultHolderAtomicTest extends BoooostCase {
    // FIX  97098 Use or lose.
    private static final byte[] BYTE_ARRAY = new byte[]{'F', 'r', 'e', 'd'};

    public void testNotNull() {
        try {
            new DefaultFreddyHolder(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    // FIX  97098 Complete.
    // FIX  97098 Do we expect to only handle byte[] at this point in time for arrays?
    public void testCloneIfArray() {
    }
}
