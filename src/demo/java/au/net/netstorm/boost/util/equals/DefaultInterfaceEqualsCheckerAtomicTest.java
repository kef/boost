package au.net.netstorm.boost.util.equals;

import au.net.netstorm.boost.demo.provider.FunkyData;
import au.net.netstorm.boost.demo.provider.Righteous;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX 2076 Should not be in demo package
public final class DefaultInterfaceEqualsCheckerAtomicTest extends InteractionTestCase implements Initialisable {
    // FIX BREADCRUMB 2076 SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS Do not use FunkyData, create own test fixture.
    FunkyData funkyDataDummy;
    String string;
    Righteous righteousDummy;
    FunkyData myFunkyData;
    FunkyData myFunkyData2;
    DefaultInterfaceEqualsChecker subject = new DefaultInterfaceEqualsChecker();

    // FIX 2076 Rename.
    public void testXxx() {
        righteousDummy.getHappyDays();
        subject.checkNotEquals(funkyDataDummy, myFunkyData);
        subject.checkEquals(myFunkyData2, myFunkyData);
    }

    public void initialise() {
        myFunkyData = new MyFunkyData(righteousDummy, string);
        myFunkyData2 = new MyFunkyData(righteousDummy, string);
    }

    public String getValue() {
        throw new UnsupportedOperationException();
    }

    public static class MyFunkyData implements FunkyData {
        private Righteous righteous;
        private String string;

        public MyFunkyData(Righteous righteous, String string) {
            this.righteous = righteous;
            this.string = string;
        }

        public Righteous getRighteous() {
            return righteous;
        }

        public String getFunkyString(String string) {
            return this.string;
        }
    }
}
