package au.net.netstorm.boost.bullet.log;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import static au.net.netstorm.boost.bullet.log.LogLevel.TRACE;
import static au.net.netstorm.boost.bullet.log.LogLevel.INFO;
import static au.net.netstorm.boost.bullet.log.LogLevel.WARN;
import static au.net.netstorm.boost.bullet.log.LogLevel.ERROR;

public final class DelegatingLogAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Log subject;
    LogEngine engineMock;
    Throwable tDummy;
    Object oDummy;

    public void setUpFixtures() {
        subject = new DelegatingLog(engineMock);
    }

    public void testTraceObject() {
        expectLog(TRACE, oDummy);
        subject.trace(oDummy);
    }

    public void testTraceThrowable() {
        expectLog(TRACE, tDummy);
        subject.trace(tDummy);
    }

    public void testTraceObjectAndThrowable() {
        expectLog(TRACE, oDummy, tDummy);
        subject.trace(oDummy, tDummy);
    }

    public void testInfoObject() {
        expectLog(INFO, oDummy);
        subject.info(oDummy);
    }

    public void testInfoThrowable() {
        expectLog(INFO, tDummy);
        subject.info(tDummy);
    }

    public void testInfoObjectAndThrowable() {
        expectLog(INFO, oDummy, tDummy);
        subject.info(oDummy, tDummy);
    }

    public void testWarnObject() {
        expectLog(WARN, oDummy);
        subject.warn(oDummy);
    }

    public void testWarnThrowable() {
        expectLog(WARN, tDummy);
        subject.warn(tDummy);
    }

    public void testWarnObjectAndThrowable() {
        expectLog(WARN, oDummy, tDummy);
        subject.warn(oDummy, tDummy);
    }

    public void testErrorObject() {
        expectLog(ERROR, oDummy);
        subject.error(oDummy);
    }

    public void testErrorThrowable() {
        expectLog(ERROR, tDummy);
        subject.error(tDummy);
    }

    public void testErrorObjectAndThrowable() {
        expectLog(ERROR, oDummy, tDummy);
        subject.error(oDummy, tDummy);
    }

    public void testLevelEnabled() {
        boolean expected = true;
        expect.oneCall(engineMock, expected, "levelEnabled", INFO);
        boolean actual = subject.levelEnabled(INFO);
        assertEquals(expected, actual);
    }

    private void expectLog(Object... expected) {
        expect.oneCall(engineMock, VOID, "log", expected);
    }
}
