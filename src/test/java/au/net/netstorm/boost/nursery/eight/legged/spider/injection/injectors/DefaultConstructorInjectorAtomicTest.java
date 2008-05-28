package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;

public final class DefaultConstructorInjectorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private ConstructorInjector subject;
    private Dummy dummy;
    private Injection[] injections;
    Provider providerMock;
    Injection injectionMock;

    public void setUpFixtures() {
        dummy = new Dummy();
        injections = new Injection[] {injectionMock};
        subject = new DefaultConstructorInjector(providerMock, injections);
    }

    public void testInject() {
        String arg = "foo";
        Object args = new Object[] {arg};
        expect.oneCall(injectionMock, arg, "apply");
        expect.oneCall(providerMock, dummy, "nu", args);
        Object result = subject.inject();
        assertSame(dummy, result);
    }
}
