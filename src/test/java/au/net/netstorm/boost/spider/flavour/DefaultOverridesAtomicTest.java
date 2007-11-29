package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultOverridesAtomicTest extends InteractionTestCase {
    private static final String ALLOW_OVERRIDES = "spider.allow.overrides";
    Overrides subject = new DefaultOverrides();
    String whatever;

    public void testIt() {
        checkAllowed(false);
        System.setProperty(ALLOW_OVERRIDES, whatever);
        checkAllowed(true);
        System.clearProperty(ALLOW_OVERRIDES);
        checkAllowed(false);
    }

    private void checkAllowed(boolean expected) {
        boolean actual = subject.allowed();
        assertEquals(expected, actual);
    }
}