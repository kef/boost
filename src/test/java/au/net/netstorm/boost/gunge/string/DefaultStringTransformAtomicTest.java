package au.net.netstorm.boost.gunge.string;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public class DefaultStringTransformAtomicTest extends LifecycleTestCase implements InjectableTest {
    StringTransform subject;

    public void testStripPrefix() {
        String result = subject.stripPrefix("abc", "a");
        assertEquals("bc", result);
    }

    public void testStripPrefixFailure() {
        try {
            subject.stripPrefix("abc", "c");
        } catch (IllegalArgumentException expected) {}
    }

    public void testStripSuffix() {
        String result = subject.stripSuffix("abc", "c");
        assertEquals("ab", result);
    }

    public void testStripSuffixFailure() {
        try {
            subject.stripSuffix("abc", "a");
        } catch (IllegalArgumentException expected) {}
    }
}
