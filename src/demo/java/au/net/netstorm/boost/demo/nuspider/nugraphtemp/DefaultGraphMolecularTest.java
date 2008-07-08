package au.net.netstorm.boost.demo.nuspider.nugraphtemp;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.DefaultFactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.DefaultGrapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Grapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

// FIX 2394 delete me when done. using this to drive up new graph implementation.
public final class DefaultGraphMolecularTest extends NuSpiderDemooooTest implements InjectableTest {
    InjectionTypeBuilder builder;

    public void testGraph() {
        InjectionType<Hello> type = builder.build(Hello.class);
        Grapher grapher = grapher();
        Hello h = grapher.graph(type);
        checkResolvedHello(h);
    }

    public void testGraphWithProvider() {
        InjectionType<NoInterface> type = builder.build(NoInterface.class);
        Grapher grapher = grapher();
        NoInterface no = grapher.graph(type);
        checkResolvedNoInterface(no);
    }

    private void checkResolvedHello(Hello instance) {
        assertEquals(true, instance instanceof DefaultHello);
        DefaultHello hello = (DefaultHello) instance;
        World world = hello.world;
        assertNotNull(world);
    }

    private void checkResolvedNoInterface(NoInterface no) {
        Hello hello = no.hello;
        checkResolvedHello(hello);
    }

    private Grapher grapher() {
        FactoryResolver resolver = resolver();
        return new DefaultGrapher(resolver);
    }

    private FactoryResolver resolver() {
        Bindings bindings = spider.resolve(Bindings.class);
        Factories factories = spider.resolve(Factories.class);
        return new DefaultFactoryResolver(bindings, factories);
    }
}
