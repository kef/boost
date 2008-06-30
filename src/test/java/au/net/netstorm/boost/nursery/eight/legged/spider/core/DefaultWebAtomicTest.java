package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class DefaultWebAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Web subject;
    FieldTestUtil fielder;
    Factories factoriesMock;
    Factory factoryMock;
    Binder binderMock;
    ConfigurableFactory configurableFactoryMock;
    NuImpl nuMock;

    public void setUpFixtures() {
        subject = new DefaultWeb(nuMock, binderMock, factoriesMock);
    }

    public void testBinder() {
        Binder actual = subject.binder();
        assertEquals(binderMock, actual);
    }

    public void testRegisterFactory() {
        expectCreateAndStore(factoryMock);
        checkRegisterFactory();
    }

    public void testRegisterConfigurableFactory() {
        expectCreateAndStore(configurableFactoryMock);
        expectConfigure();
        checkRegisterFactory();
    }

    private void checkRegisterFactory() {
        subject.register(MockFactory.class);
    }

    private void expectCreateAndStore(Factory factory) {
        Object args = new Object[0];
        expect.oneCall(nuMock, factory, "nu", MockFactory.class, args);
        expect.oneCall(factoriesMock, VOID, "add", factory);
    }

    private void expectConfigure() {
        expect.oneCall(configurableFactoryMock, VOID, "configure", binderMock);
    }
}
