package au.net.netstorm.boost.demo.provider;

import java.lang.reflect.Proxy;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.sniper.automock.DefaultMockSupport;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.sniper.random.ImplementationNotFoundException;
import au.net.netstorm.boost.sniper.random.InterfaceRandomProvider;
import au.net.netstorm.boost.sniper.random.RandomProviderAssembler;
import au.net.netstorm.boost.sniper.specific.DataProviders;
import au.net.netstorm.boost.sniper.specific.DefaultDataProviders;
import au.net.netstorm.boost.sniper.specific.DefaultEnumProvider;
import au.net.netstorm.boost.sniper.specific.EnumProvider;

public final class InterfaceRandomProviderDemoTest extends LifecycleTestCase implements HasFixtures {
    private MockSupport mocks = new DefaultMockSupport();
    private Class iFace = HappyDay.class;
    private Class impl = DefaultHappyDay.class;
    private DataProviders data = new DefaultDataProviders();
    private EnumProvider enums = new DefaultEnumProvider();
    private SpecificProvider interfaceProvider;
    private Random random;

    public void setUpFixtures() {
        setUpDataProviders();
        RandomProviderAssembler providerAssembler = new DefaultRandomProviderAssembler();
        random = providerAssembler.everything(data, enums, mocks);
        interfaceProvider = new InterfaceRandomProvider(random, data, enums, mocks);
    }

    private void setUpDataProviders() {
        HappinessProvider happinessProvider = new HappinessProvider();
        data.add(Happiness.class, happinessProvider);
        enums.add(FancyPants.class);
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