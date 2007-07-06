package au.net.netstorm.boost.demo.provider;

import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;
import au.net.netstorm.boost.test.specific.UsesSpecifics;

// FIX 2076 Tidy this up.

// FIX 2076 Looks like it is not a random provider test any more.
public final class RandomProviderDemoTest extends InteractionTestCase implements UsesSpecifics {
    FunkyData funkyDataDummy;
    FunkyData anotherFunkyDataDummy;
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

    // FIX 2076 Remove or use.
    public void testRepeatedEqualsDoesNotInfiniteLoop() {
        funkyDataDummy.equals(anotherFunkyDataDummy);
        funkyDataDummy.equals(anotherFunkyDataDummy);
        funkyDataDummy.equals(funkyDataDummy);
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
        String funkyDataToString3 = anotherFunkyDataDummy.toString();
        assertEquals(true, funkyDataToString1.contains(funkyDataClassName));
        assertEquals(funkyDataToString1, funkyDataToString2);
        assertNotEquals(funkyDataToString1, funkyDataToString3);
    }

    private void checkHashCodeAndEquals() {
        Set set = new HashSet();
        set.add(funkyDataDummy);
        boolean actual = set.contains(funkyDataDummy);
        assertEquals(true, actual);
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
    }
}
