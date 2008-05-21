package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultProvidersAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    Providers subject;
    ProviderFactory factoryMock;
    Provider providerMock;
    InjectionSite siteMock;

    public void setUpFixtures() {
        subject.add(factoryMock);
    }

    public void testAddFailure() {
        checkAddFails(factoryMock);
        checkAddFails(null);
    }

    public void testFind() {
        expect.oneCall(factoryMock, true, "canHandle", siteMock);
        expect.oneCall(factoryMock, providerMock, "nu", siteMock);
        Provider result = subject.find(siteMock);
        assertSame(providerMock, result);
    }

    public void testFindFailure() {
        expect.oneCall(factoryMock, false, "canHandle", siteMock);
        try {
            subject.find(siteMock);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    private void checkAddFails(ProviderFactory factory) {
        try {
            subject.add(factory);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
