package au.net.netstorm.boost.demo.provider;

import java.lang.reflect.Proxy;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.automock.AutoMocker;
import au.net.netstorm.boost.test.automock.DefaultAutoMocker;
import au.net.netstorm.boost.test.automock.DefaultMockObjectTestCase;
import au.net.netstorm.boost.test.automock.DefaultMockProvider;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockObjectTestCase;
import au.net.netstorm.boost.test.automock.MockProvider;
import au.net.netstorm.boost.test.random.InterfaceRandomProvider;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.ProvidesData;

public final class InterfaceRandomProviderDemoTest extends InteractionTestCase implements Initialisable, ProvidesData {
    MockObjectTestCase mockObjectTestCase = new DefaultMockObjectTestCase();
    MockProvider mockProvider = new DefaultMockProvider(mockObjectTestCase);
    AutoMocker mocker = new DefaultAutoMocker(mockProvider);
    SpecificProvider interfaceProvider;
    Class iFace = HappyDay.class;
    Class impl = DefaultHappyDay.class;

    public void initialise() {
        interfaceProvider = new InterfaceRandomProvider(random, data, mocker);
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

    public void testUsesProvidedImplementations() {
        checkImpl(Happiness.class, DefaultHappiness.class);
    }

    public void testProvidesMocksForNonDataClasses() {
        Object object = interfaceProvider.provide(HasNoDefaultImpl.class);
        assertEquals(true, Proxy.isProxyClass(object.getClass()));
        // Check mock came from mocker
        mocker.get(object);
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
        FunkyData funkyData = (FunkyData) interfaceProvider.provide(FunkyData.class);
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

    public void register(DataProviders dataProviders) {
        HappinessProvider happinessProvider = new HappinessProvider();
        dataProviders.add(Happiness.class, happinessProvider);
    }
}