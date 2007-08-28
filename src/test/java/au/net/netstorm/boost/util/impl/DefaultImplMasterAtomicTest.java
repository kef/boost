package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplMasterAtomicTest extends InteractionTestCase {
    ImplMaster subject = new DefaultImplMaster();

    public void testHasDefaultImpl() {
        Interface sunshine = new DefaultInterface(Sunshine.class);
        assertEquals(true, subject.hasImpl(sunshine));
        Implementation expected = new DefaultImplementation(DefaultSunshine.class);
        assertEquals(expected, subject.impl(sunshine));
    }

    public void testDoesNotHaveDefaultImpl() {
        Interface moonlight = new DefaultInterface(Moonlight.class);
        assertEquals(false, subject.hasImpl(moonlight));
        try {
            subject.impl(moonlight);
            fail();
        } catch (EdgeException expected) {}
    }
}
