package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.RootInjection;

public final class DefaultNuInjectionGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private NuInjectionGraph subject;
    GraphBuilder builderMock;
    RootInjection rootMock;

    public void setUpFixtures() {
        subject = new DefaultNuInjectionGraph(builderMock);
    }

    public void testNu() {
        expect.oneCall(builderMock, rootMock, "build", Ball.class);
        InjectionGraph<Ball> graph = subject.nu(Ball.class);
        // FIX 2394 colour me in
    }
}
