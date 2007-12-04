package au.net.netstorm.boost.demo.provider;

import java.lang.reflect.Proxy;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.test.automock.DefaultMockSupport;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.test.random.ImplementationNotFoundException;
import au.net.netstorm.boost.test.random.InterfaceRandomProvider;
import au.net.netstorm.boost.test.random.RandomProviderAssembler;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.DefaultDataProviders;

public final class InterfaceRandomProviderDemoTest extends LifecycleTestCase implements Constructable, LazyFields {
    private MockSupport mocks = new DefaultMockSupport();
    private Class iFace = HappyDay.class;
    private Class impl = DefaultHappyDay.class;
    private DataProviders dataProviders = new DefaultDataProviders();
    private Random random;
    private SpecificProvider interfaceProvider;

    public InterfaceRandomProviderDemoTest() {
        RandomProviderAssembler providerAssembler = new DefaultRandomProviderAssembler();
        random = providerAssembler.everything(dataProviders, mocks);
        interfaceProvider = new InterfaceRandomProvider(random, dataProviders, mocks);
    }

    public void constructor() {
        HappinessProvider happinessProvider = new HappinessProvider();
        dataProviders.add(Happiness.class, happinessProvider);
    }

    public void testCanProvide() {
        assertEquals(true, interfaceProvider.canProvide(iFace));
        assertEquals(false, interfaceProvider.canProvide(impl));
    }

    public void testPopsWhenProvidingNonInterface() {
        try {
            interfaceProvider.provide(impl);
        } catch (NotProvidedException expected) {}
    }

    public void testPopsWhenNoImplExistsForData() {
        try {
            interfaceProvider.provide(HasNoDefaultImpl.class);
            fail();
        } catch (ImplementationNotFoundException actual) {}
    }

    public void testUsesProvidedImplementations() {
        checkImpl(Happiness.class, DefaultHappiness.class);
    }

    public void testProvidesMocksForNonDataClasses() {
        Object object = interfaceProvider.provide(Grumpiness.class);
        assertEquals(true, Proxy.isProxyClass(object.getClass()));
        // Check mock came from mocker
        mocks.mockForProxy(object);
    }

    public void testProvidesDefaultImplementations() {
        checkImpl(HappyDay.class, DefaultHappyDay.class);
    }

    private void checkImpl(Class iFace, Class expectedImpl) {
        Object object = interfaceProvider.provide(iFace);
        Class actualImpl = object.getClass();
        assertEquals(expectedImpl, actualImpl);
    }

    public void testRecursionOfProvision() {
        FunkyData funkyData = interfaceProvider.provide(FunkyData.class);
        String funkyString = funkyData.getFunkyString();
        assertNotNull(funkyString);
        checkRighteous(funkyData);
    }

    private void checkRighteous(FunkyData funkyData) {
        Righteous righteous = funkyData.getRighteous();
        HappyDay[] happyDays = righteous.getHappyDays();
        checkHappyDays(happyDays);
    }

    private void checkHappyDays(HappyDay[] happyDays) {
        for (int i = 0; i < happyDays.length; i++) {
            checkHappyDay(happyDays[i]);
        }
    }

    private void checkHappyDay(HappyDay happyDay) {
        assertEquals(true, happyDay instanceof DefaultHappyDay);
        long timeMillis = happyDay.getTimeMillis();
        assertEquals(true, timeMillis != 0);
    }
}