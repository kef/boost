package au.net.netstorm.boost.util.tostring;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import junit.framework.Assert;

public final class DefaultFroggerAtomicTest extends LifecycleTestCase {
    Frogger subject = new DefaultFrogger();

    public void testFroggification() {
        checkFroggification("LILY_PAD", "Lily Pad");
        checkFroggification("TASTY_FAT_FLY", "Tasty Fat Fly");
        checkFroggification("", "");
        checkFroggification("_A_LEADING_UNDERSCORE_", "A Leading Underscore");
    }

    private void checkFroggification(String input, String output) {
        String actual = subject.froggify(input);
        Assert.assertEquals(output, actual);
    }
}
