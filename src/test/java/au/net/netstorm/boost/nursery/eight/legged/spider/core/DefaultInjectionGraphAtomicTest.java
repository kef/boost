package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;

public final class DefaultInjectionGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionGraph<Ball> subject;
    Injection rootMock;
    Ball ballMock;

    public void setUpFixtures() {
        subject = new DefaultInjectionGraph(Ball.class, rootMock);
    }

    public void testApply() {
        // FIX 2394 reinstate once i decide the different stratergies for parameterized v non-parameterized
//        Object[] args = {"a", "b"};
//        expect.oneCall(rootMock, ballMock, "apply", (Object) args);
//        Ball result = subject.apply(args);
//        assertSame(ballMock, result);
    }
}
