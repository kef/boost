package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.test.core.BoooostCase;

// FIX BREADCRUMB  97098 Complete me.
public final class DefaultHolderAtomicTest extends BoooostCase {
    public void testNotNull() {
        try {
            new DefaultFreddyHolder(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
