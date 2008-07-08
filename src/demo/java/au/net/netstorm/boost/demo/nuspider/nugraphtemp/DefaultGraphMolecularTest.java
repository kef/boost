package au.net.netstorm.boost.demo.nuspider.nugraphtemp;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.DefaultFactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph.DefaultGrapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph.Grapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImplProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

// FIX 2394 delete me when done. using this to drive up new graph implementation.
public final class DefaultGraphMolecularTest extends NuSpiderDemooooTest implements InjectableTest {
    InjectionTypeBuilder builder;

    public void testGraph() {
        InjectionType type = builder.build(Hello.class);
        Grapher grapher = grapher();
        Object o = grapher.graph(type);
        checkResolvedHello(o);
    }

    public void testGraphWithProvider() {
        Implementation impl = new DefaultImplementation(NoInterface.class);
        Provider provider = new ImplProvider(impl);
        InjectionType type = builder.build(NoInterface.class);
        Grapher grapher = grapher();
        Object o = grapher.graph(type, provider);
        checkResolvedNoInterface(o);
    }

    private void checkResolvedHello(Object instance) {
        assertEquals(true, instance instanceof DefaultHello);
        DefaultHello hello = (DefaultHello) instance;
        World world = hello.world;
        assertNotNull(world);
    }

    private void checkResolvedNoInterface(Object instance) {
        assertEquals(true, instance instanceof NoInterface);
        NoInterface no = (NoInterface) instance;
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
