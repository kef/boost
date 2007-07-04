package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.test.random.EverythingRandomProvider;
import au.net.netstorm.boost.test.random.RandomProvider;

public final class RandomProviderDemoTest extends BoooostCase {
    private final RandomProvider randomProvider = new EverythingRandomProvider();

    public void testInterfaceProvider() {
        FunkyData funkyData = (FunkyData) randomProvider.get(FunkyData.class);
        Righteous righteous = checkRighteous(funkyData);
        checkHappyDays(righteous);
    }

    private void checkHappyDays(Righteous righteous) {
        HappyDay[] happyDays = righteous.getHappyDays();
        for (HappyDay happyDay : happyDays) {
            checkHappyDay(happyDay);
            checkHappyDaysDifferent(happyDay);
        }
    }

    private Righteous checkRighteous(FunkyData funkyData) {
        Righteous righteous = funkyData.getRighteous();
        assertNotNull(righteous);
        return righteous;
    }

    private void checkHappyDay(HappyDay happyDay) {
        long time1 = happyDay.getTimeMillis();
        long time2 = happyDay.getTimeMillis();
        assertNotEquals(0, time1);
        assertEquals(time1, time2);
    }

    private void checkHappyDaysDifferent(HappyDay existingHappyDay) {
        HappyDay anotherHappyDay = (HappyDay) randomProvider.get(HappyDay.class);
        long time1 = existingHappyDay.getTimeMillis();
        long time2 = anotherHappyDay.getTimeMillis();
        assertNotEquals(time1, time2);
    }
}
