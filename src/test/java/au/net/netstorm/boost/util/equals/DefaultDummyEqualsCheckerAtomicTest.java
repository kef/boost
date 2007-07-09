package au.net.netstorm.boost.util.equals;

import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX 2076 Should this be testing DummyEqualsMaster directly?
public final class DefaultDummyEqualsCheckerAtomicTest extends InteractionTestCase implements Initialisable {
    DummyEqualsChecker subject = new DefaultDummyEqualsChecker();
    String string;
    Fin fin;
    Fin finDummy;
    Nose noseDummy;
    Rocket rocketDummy;
    Rocket rocketData1;
    Rocket rocketData2;

    public void initialise() {
        rocketData1 = new EstesRocket(finDummy, noseDummy);
        rocketData2 = new EstesRocket(finDummy, noseDummy);
    }

    public void testDifferentObjectsAndDummiesAreNotEqual() {
        subject.checkNotEquals(rocketDummy, rocketData1);
    }

    public void testSameObjectAndDummiesAreEqual() {
        subject.checkEquals(rocketData2, rocketData1);
    }
}
