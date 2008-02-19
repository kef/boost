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

    public void testCloneIfArray() {
        FreddyHolder holder = new DefaultFreddyHolder(BYTE_ARRAY);
        byte[] value = holder.getValue();
        checkCloneIfArray(value);
    }

    // FIX BREADCRUMB  97098 Complete me
    public void testEquals() {

    }

    private void checkCloneIfArray(byte[] value) {
        checkReference(value);
        checkArray(value);
    }

    private void checkReference(byte[] value) {
        boolean actual = value != BYTE_ARRAY;
        assertEquals(true, actual);
    }

    private void checkArray(byte[] value) {
        assertEquals(BYTE_ARRAY, value);
    }
}
