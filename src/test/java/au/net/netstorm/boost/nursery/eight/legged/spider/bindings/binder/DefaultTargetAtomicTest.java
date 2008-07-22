package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.MutableBinding;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ProviderFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.Dummy;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.InstanceProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultTargetAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Target subject;
    FieldTestUtil fielder;
    MutableBinding bindingMock;
    Object instanceDummy;
    Class implDummy = Dummy.class;

    public void setUpFixtures() {
        subject = new DefaultTarget(bindingMock);
    }

    public void testToInstance() {
        Provider provider = new InstanceProvider(instanceDummy);
        Factory factory = new ProviderFactory(provider);
        setBindingExpectations(factory);
        subject.to(instanceDummy);
    }

    private void setBindingExpectations(Factory factory) {
        expect.oneCall(bindingMock, VOID, "setFactory", factory);
    }
}
