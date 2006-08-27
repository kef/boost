package au.net.netstorm.boost.time.type;

import au.net.netstorm.boost.test.reflect.util.DefaultClassTestUtil;
import junit.framework.TestCase;

public final class TimeConstantsAtomicTest extends TestCase {

    // FIX SC600 Strengthen this to ensure constructor is private.
    public void testPrivateConstructor() {
        new DefaultClassTestUtil().newInstance(TimeConstants.class);
    }

    public void testConstant() {
        assertEquals(1, TimeConstants.ONE_MILLISECOND);
        assertEquals(1000 * TimeConstants.ONE_MILLISECOND, TimeConstants.ONE_SECOND);
        assertEquals(60 * TimeConstants.ONE_SECOND, TimeConstants.ONE_MINUTE);
        assertEquals(60 * TimeConstants.ONE_MINUTE, TimeConstants.ONE_HOUR);
        assertEquals(24 * TimeConstants.ONE_HOUR, TimeConstants.ONE_DAY);
        assertEquals(7 * TimeConstants.ONE_DAY, TimeConstants.ONE_WEEK);
        assertEquals(365 * TimeConstants.ONE_DAY, TimeConstants.ONE_YEAR);
    }
}