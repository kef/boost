package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.test.automock.DefaultMockSupport;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.test.random.ImplementationNotFoundException;
import au.net.netstorm.boost.test.random.InterfaceRandomProvider;
import au.net.netstorm.boost.test.random.RandomProviderAssembler;
import au.net.netstorm.boost.test.specific.DataDataProviders;
import au.net.netstorm.boost.test.specific.DefaultDataDataProviders;
import au.net.netstorm.boost.test.specific.DefaultEnumDataProviders;
import au.net.netstorm.boost.test.specific.EnumDataProviders;

import java.lang.reflect.Proxy;

public final class InterfaceRandomProviderDemoTest extends LifecycleTestCase implements HasFixtures {
    private MockSupport mocks = new DefaultMockSupport();
    private Class iFace = HappyDay.class;
    private Class impl = DefaultHappyDay.class;
    private DataDataProviders dataProviders = new DefaultDataDataProviders();
    private EnumDataProviders enumProviders = new DefaultEnumDataProviders();
    private SpecificProvider interfaceProvider;
    private Random random;

    public void setUpFixtures() {
        setUpDataProviders();
        RandomProviderAssembler providerAssembler = new DefaultRandomProviderAssembler();
        random = providerAssembler.everything(dataProviders, enumProviders, mocks);
        interfaceProvider = new InterfaceRandomProvider(random, dataProviders, enumProviders, mocks);
    }

    private void setUpDataProviders() {
        HappinessProvider happinessProvider = new HappinessProvider();
        dataProviders.add(Happiness.class, happinessProvider);
        FancyPantsProvider fancyPantsProvider = new FancyPantsProvider();
        enumProviders.add(FancyPants.class, fancyPantsProvider);
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
        for (HappyDay happyDay : happyDays) {
            checkHappyDay(happyDay);
        }
    }

    private void checkHappyDay(HappyDay happyDay) {
        assertEquals(true, happyDay instanceof DefaultHappyDay);
        long timeMillis = happyDay.getTimeMillis();
        assertEquals(true, timeMillis != 0);
    }
}