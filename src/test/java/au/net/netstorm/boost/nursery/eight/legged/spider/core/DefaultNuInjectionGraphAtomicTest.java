package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultNuInjectionGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private NuInjectionGraph subject;
    GraphBuilder builderMock;
    InjectionTypeBuilder typesMock;
    InjectionType typeMock;
    Injection rootMock;
    FieldTestUtil fielder;

    public void setUpFixtures() {
        subject = new DefaultNuInjectionGraph(builderMock);
        fielder.setInstance(subject, "types", typesMock);
    }

    public void testNu() {
        expect.oneCall(typesMock, typeMock, "build", Ball.class);
        expect.oneCall(builderMock, rootMock, "build", typeMock);
        InjectionGraph<Ball> graph = subject.nu(Ball.class);
        // FIX 2394 colour me in
    }
}
