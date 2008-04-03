package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.InjectableTest;

public final class DefaultClosuresAtomicTest extends LifecycleTestCase implements InjectableTest {
    Closures subject;
    Oven oven;
    Pie pie;

    public void testClosure() {
        Pie closed = subject.closure(CookLayer.class, pie, oven);
        closed.cook();
        checkOvenUsed();
        checkPieCooked();
    }

    private void checkOvenUsed() {
        boolean actual = oven.used();
        assertEquals(true, actual);
    }

    private void checkPieCooked() {
        boolean actual = pie.hotAndTasty();
        assertEquals(true, actual);
    }
}