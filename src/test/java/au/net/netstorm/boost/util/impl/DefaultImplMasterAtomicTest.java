package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplMasterAtomicTest extends InteractionTestCase {
    // FIX 1914 Dupe.  See InterfaceRandomProvider.
    ImplMapper mapper = new BasicImplMapper();
    ImplMapper[] mappers = {mapper};
    ImplMaster subject = new DefaultImplMaster(mappers);

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
            // FIX 1914 Strong type exception.
        } catch (IllegalStateException expected) {}
    }
}
