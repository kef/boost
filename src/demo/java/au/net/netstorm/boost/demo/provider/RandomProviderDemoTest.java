package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.ProvidesData;

// FIX 2076 Rename to InterfaceProviderDemoTest and use to drive out InterfaceRandomProvider...
public final class RandomProviderDemoTest extends InteractionTestCase implements Initialisable, ProvidesData {
    FunkyData funkyDataDummy;

    public void testInterfaceProvider() {
        assertNotNull(funkyDataDummy);
        String funkyString = funkyDataDummy.getFunkyString();
        assertNotNull(funkyString);
        checkRighteous();
    }

    private void checkRighteous() {
        Righteous righteous = funkyDataDummy.getRighteous();
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