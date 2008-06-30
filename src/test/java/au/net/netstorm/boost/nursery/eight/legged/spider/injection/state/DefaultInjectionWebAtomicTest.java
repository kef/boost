package au.net.netstorm.boost.nursery.eight.legged.spider.injection.state;

import java.util.LinkedList;
import java.util.Queue;

import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.LazyInjectionCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.LazyProviderCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultInjectionWebAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionWeb subject;
    FieldTestUtil fielder;
    FactoryResolver resolverMock;
    IntegrityMap providersMock;
    IntegrityMap injectionsMock;
    Provider providerMock;
    InjectionSite siteMock;
    Injection injectionMock;

    public void setUpFixtures() {
        subject = new DefaultInjectionWeb(resolverMock);
        fielder.setInstance(subject, "providers", providersMock);
        fielder.setInstance(subject, "injections", injectionsMock);
    }
    
    public void testProvider() {
        LazyProviderCreator creator = new LazyProviderCreator(resolverMock);
        expect.oneCall(providersMock, providerMock, "getOrCreate", siteMock, creator);
        Provider result = subject.provider(siteMock);
        assertSame(providerMock, result);
    }

    public void testInjection() {
        Queue toBuild = new LinkedList();
        LazyInjectionCreator creator = new LazyInjectionCreator(toBuild);
        expect.oneCall(injectionsMock, injectionMock, "getOrCreate", siteMock, creator);
        Injection result = subject.injection(siteMock);
        assertSame(injectionMock, result);
    }

    // FIX 2394 nasty work queue hack should be driven away
}
