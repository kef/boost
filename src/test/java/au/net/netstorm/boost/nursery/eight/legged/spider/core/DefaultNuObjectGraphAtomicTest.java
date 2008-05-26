package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultNuObjectGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private NuObjectGraph subject;
    Ball ballMock;
    NuInjectionGraph injectionsMock;
    InjectionGraph<Ball> graphMock;

    public void setUpFixtures() {
        subject = new DefaultNuObjectGraph(injectionsMock);
    }

    public void testNu() {
        Object args = new Object[0];
        expect.oneCall(injectionsMock, graphMock, "nu", Ball.class);
        expect.oneCall(graphMock, ballMock, "apply", args);
        checkNu();
    }

    private void checkNu() {
        Ball result = subject.nu(Ball.class);
        assertSame(ballMock, result);
    }
}
