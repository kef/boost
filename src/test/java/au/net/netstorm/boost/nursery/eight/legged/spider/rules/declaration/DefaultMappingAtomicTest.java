package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ProviderFactory;

public final class DefaultMappingAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Mapping subject;
    RuleBuilder builderMock;
    Provider providerMock;
    Factory factoryMock;

    public void setUpFixtures() {
        subject = new DefaultMapping(builderMock);
    }

    public void testToInstance() {
        Factory expected = new MockFactory(ProviderFactory.class);
        expect.oneCall(builderMock, VOID, "setMapping", expected);
        subject.to(new GreenTree());
    }

    public void testToImplementation() {
        Factory expected = new MockFactory(ProviderFactory.class);
        expect.oneCall(builderMock, VOID, "setMapping", expected);
        subject.to(GreenTree.class);
    }

    public void testToProvider() {
        Factory expected = new MockFactory(ProviderFactory.class);
        expect.oneCall(builderMock, VOID, "setMapping", expected);
        subject.to(providerMock);
    }

    public void testToFactory() {
        expect.oneCall(builderMock, VOID, "setMapping", factoryMock);
        subject.to(factoryMock);
    }
}