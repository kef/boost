package au.net.netstorm.boost.util.equals;

import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX 2076 Should not be in demo package
public final class DefaultInterfaceEqualsCheckerAtomicTest extends InteractionTestCase implements Initialisable {
    DefaultInterfaceEqualsChecker subject = new DefaultInterfaceEqualsChecker();
    // FIX BREADCRUMB 2076 SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS Do not use FunkyData, create own test fixture.
    String string;
    Fin fin;
    Fin finDummy;
    Nose noseDummy;
    Rocket rocketDummy;
    Rocket rocketData1;
    Rocket rocketData2;

    // FIX 2076 Rename.
    public void testXxx() {
        subject.checkNotEquals(rocketDummy, rocketData1);
        subject.checkEquals(rocketData2, rocketData1);
    }

    public void initialise() {
        rocketData1 = new EstesRocket(finDummy, noseDummy);
        rocketData2 = new EstesRocket(finDummy, noseDummy);
    }

    public String getValue() {
        throw new UnsupportedOperationException();
    }

    // FIX 2076 Move out into separate test fixture.
    public static class EstesRocket implements Rocket {
        private Fin fins;
        private Nose nose;

        public EstesRocket(Fin fins, Nose nose) {
            this.fins = fins;
            this.nose = nose;
        }

        public Fin getFin() {
            return fins;
        }

        public Nose getNose() {
            return nose;
        }
    }
}
