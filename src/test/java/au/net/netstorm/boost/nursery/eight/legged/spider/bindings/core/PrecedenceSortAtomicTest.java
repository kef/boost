package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;

public final class PrecedenceSortAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private static final int EQUAL_TO = 0;
    private static final int GREATER_THAN = 1;
    private static final int LESS_THAN = -1;
    private PrecedenceSort subject;
    Binding smallMock;
    Binding bigMock;

    public void setUpFixtures() {
        subject = new PrecedenceSort();
    }

    public void testCompare() {
        setPrecedenceExpectation(smallMock, Precedence.HOSTED_AND_NAMED);
        setPrecedenceExpectation(bigMock, Precedence.HOSTED);
        checkCompare(EQUAL_TO, smallMock, smallMock);
        checkCompare(EQUAL_TO, bigMock, bigMock);
        checkCompare(LESS_THAN, smallMock, bigMock);
        checkCompare(GREATER_THAN, bigMock, smallMock);
    }

    private void checkCompare(int expected, Binding b1, Binding b2) {
        int result = subject.compare(b1, b2);
        assertEquals(expected, result);
    }

    private void setPrecedenceExpectation(Binding b, Precedence p) {
        expect.manyCalls(b, p, "getPrecedence");
    }
}
