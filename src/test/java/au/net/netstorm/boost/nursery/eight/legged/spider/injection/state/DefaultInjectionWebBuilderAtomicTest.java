package au.net.netstorm.boost.nursery.eight.legged.spider.injection.state;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.DefaultFactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultInjectionWebBuilderAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    InjectionWebBuilder subject;
    Bindings bindingsMock;
    Factories factoriesMock;

    public void testBuild() {
        FactoryResolver resolver = new DefaultFactoryResolver(bindingsMock, factoriesMock);
        InjectionWeb expected = new DefaultInjectionWeb(resolver);
        InjectionWeb actual = subject.build(bindingsMock, factoriesMock);
        assertEquals(expected, actual);
    }
}
