package au.net.netstorm.boost.gunge.collection;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;

public final class DefaultFailerAtomicTest extends LifecycleTestCase {
    private Object dummy = new Object();

    public void testApply() {
        Failer subject = new DefaultFailer();
        try {
            subject.apply(dummy);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
