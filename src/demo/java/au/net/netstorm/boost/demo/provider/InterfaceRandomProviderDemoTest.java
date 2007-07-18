package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.automock.AutoMocker;
import au.net.netstorm.boost.test.automock.DefaultAutoMocker;
import au.net.netstorm.boost.test.automock.DefaultMockObjectTestCase;
import au.net.netstorm.boost.test.automock.DefaultMockProvider;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockProvider;
import au.net.netstorm.boost.test.random.InterfaceRandomProvider;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.ProvidesData;
import org.jmock.MockObjectTestCase;

// FIX 2076 Use to drive out InterfaceRandomProvider...
public final class InterfaceRandomProviderDemoTest extends InteractionTestCase implements Initialisable, ProvidesData {
    MockObjectTestCase mockObjectTestCase = new DefaultMockObjectTestCase();
    MockProvider mockProvider = new DefaultMockProvider(mockObjectTestCase);
    AutoMocker mocker = new DefaultAutoMocker(mockProvider);
    Provider interfaceProvider;

    public InterfaceRandomProviderDemoTest() {
        this.interfaceProvider = new InterfaceRandomProvider(random, data, mocker);
    }

    public void testInterfaceProvider() {
        FunkyData funkyData = (FunkyData) interfaceProvider.provide(FunkyData.class);
        assertNotNull(funkyData);
        String funkyString = funkyData.getFunkyString();
        assertNotNull(funkyString);
        checkRighteous(funkyData);
    }

    private void checkRighteous(FunkyData funkyData) {
        Righteous righteous = funkyData.getRighteous();
        assertNotNull(righteous);
        HappyDay[] happyDays = righteous.getHappyDays();
        checkHappyDays(happyDays);
    }

    private void checkHappyDays(HappyDay[] happyDays) {
        assertNotNull(happyDays);
        for (int i = 0; i < happyDays.length; i++) {
            checkHappyDay(happyDays[i]);
        }
    }

    private void checkHappyDay(HappyDay happyDay) {
        assertNotNull(happyDay);
        assertEquals(true, happyDay instanceof DefaultHappyDay);
        long timeMillis = happyDay.getTimeMillis();
        assertEquals(true, timeMillis != 0);
    }

    public void initialise() {
    }

    public void register(DataProviders dataProviders) {
        HappinessProvider happinessProvider = new HappinessProvider();
        dataProviders.add(Happiness.class, happinessProvider);
    }
}