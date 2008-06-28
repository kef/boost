package au.net.netstorm.boost.nursery.eight.legged.spider.resolver;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Binding;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultFactoryResolverAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private FactoryResolver subject;
    private List list;
    Factories factoriesMock;
    Bindings bindingsMock;
    InjectionSite siteMock;
    Factory factoryMock;
    InjectionType typeMock;
    Iterator iterMock;
    Binding bindingMock;

    public void setUpFixtures() {
        subject = new DefaultFactoryResolver(bindingsMock, factoriesMock);
        list = new ArrayList();
        list.add(bindingMock);
        expect.oneCall(siteMock, typeMock, "type");
    }

    public void testShortCircuit() {
        expectBindingAcceptsSite(true);
        expectShortCircuits();
        checkResolve();
    }

    public void testWildcardFactory() {
        expectBindingAcceptsSite(false);
        expectDefaultsToWildcardFactories();
        checkResolve();
    }

    private void expectBindingAcceptsSite(boolean accepts) {
        expect.oneCall(bindingsMock, list, "lookup", typeMock);
        expect.oneCall(bindingMock, accepts, "accepts", siteMock);
    }

    private void expectShortCircuits() {
        expect.oneCall(bindingMock, factoryMock, "getFactory", siteMock);
    }

    private void expectDefaultsToWildcardFactories() {
        expect.oneCall(factoriesMock, factoryMock, "find", siteMock);
    }

    private void checkResolve() {
        Factory result = subject.resolve(siteMock);
        assertEquals(factoryMock, result);
    }
}
