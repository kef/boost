package au.net.netstorm.boost.util.equals;

import junit.framework.Assert;

// FIX 2076 Use or lose.
public final class DefaultDummyEqualsChecker implements DummyEqualsChecker {
    DummyEqualsMaster equaler = new DummyEqualsMaster();

    // FIX 2076 Exciting, informative message.
    public void checkEquals(Object o1, Object o2) {
        boolean equal = equaler.equals(o1, o2);
        Assert.assertTrue("Not equal!", equal);
    }

    // FIX 2076 Exciting, informative message.
    public void checkNotEquals(Object o1, Object o2) {
        boolean equal = equaler.equals(o1, o2);
        Assert.assertTrue("Equal!", !equal);
    }
}
