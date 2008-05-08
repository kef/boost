package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class CyclicConstructableResolutionAtomicTest extends LifecycleTestCase implements InjectableTest {
    Resolver subject;

    public void test() {
        subject.resolve(X.class);
    }
}