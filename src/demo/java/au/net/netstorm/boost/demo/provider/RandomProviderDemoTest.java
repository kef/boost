package au.net.netstorm.boost.demo.provider;

import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.specific.RegistersSpecifics;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;

public final class RandomProviderDemoTest extends InteractionTestCase implements RegistersSpecifics {

    FunkyData funkyDataDummy;
    HappyDay anotherHappyDayDummy;

    public void testInterfaceProvider() {
        checkEqualsHashCodeAndToString();
        checkParamsAffectReturnedObject();
        assertEquals(funkyDataDummy, funkyDataDummy);
        Righteous righteous = checkRighteous(funkyDataDummy);
        checkHappyDays(righteous);
    }

    public void registerSpecifics(SpecificProviderRegistry specifics) {
        HappinessProvider happinessProvider = new HappinessProvider();
        specifics.add(Happiness.class, happinessProvider);
    }

    private void checkParamsAffectReturnedObject() {
        String funkyString1 = funkyDataDummy.getFunkyString("String1");
        String funkyString2 = funkyDataDummy.getFunkyString("String2");
        String funkyString3 = funkyDataDummy.getFunkyString("String2");
        assertNotEquals(funkyString1, funkyString2);
        assertEquals(funkyString2, funkyString3);
    }

    private void checkEqualsHashCodeAndToString() {
        checkHashCodeAndEquals();
        checkToString();
    }

    private void checkToString() {
        String funkyDataClassName = FunkyData.class.getName();
        String funkyDataToString1 = funkyDataDummy.toString();
        String funkyDataToString2 = funkyDataDummy.toString();
        assertEquals(true, funkyDataToString1.contains(funkyDataClassName));
        assertEquals(funkyDataToString1, funkyDataToString2);
        System.out.println("funkyDataToString2 = " + funkyDataToString2);
    }

    private void checkHashCodeAndEquals() {
        Set set = new HashSet();
        set.add(funkyDataDummy);
        assertEquals(true, set.contains(funkyDataDummy));
    }

    private Righteous checkRighteous(FunkyData funkyData) {
        Righteous righteous = funkyData.getRighteous();
        assertNotNull(righteous);
        return righteous;
    }

    private void checkHappyDays(Righteous righteous) {
        HappyDay[] happyDays = righteous.getHappyDays();
        for (HappyDay happyDay : happyDays) {
            checkHappyDay(happyDay);
            checkHappyDaysDifferent(happyDay);
        }
    }

    private void checkHappyDay(HappyDay happyDay) {
        long time1 = happyDay.getTimeMillis();
        long time2 = happyDay.getTimeMillis();
        assertNotEquals(0, time1);
        assertEquals(time1, time2);
    }

    private void checkHappyDaysDifferent(HappyDay existingHappyDay) {
        long time1 = existingHappyDay.getTimeMillis();
        long time2 = anotherHappyDayDummy.getTimeMillis();
        assertNotEquals(time1, time2);
        checkHappiness(existingHappyDay);
    }

    private void checkHappiness(HappyDay happyDay) {
        Happiness happiness1 = happyDay.getHappiness();
        Happiness happiness2 = happyDay.getHappiness();
        assertNotNull(happiness1);
        assertNotNull(happiness2);
        assertEquals(happiness1, happiness2);
        System.out.println("happiness2 = " + happiness2);
    }
}
