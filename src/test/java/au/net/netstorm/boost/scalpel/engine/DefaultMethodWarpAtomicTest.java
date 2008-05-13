package au.net.netstorm.boost.scalpel.engine;

import java.io.InputStream;
import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMethodWarpAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private MethodWarp subject;
    StreamFixture stream;
    EdgeClass classerMock;
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultMethodWarp();
    }

    public void testWarp() {
        expect.oneCall(classerMock, stream.realMethod(), "getMethod", InputStream.class, stream.methodName(), stream.argTypes());
        expect.oneCall(unedgerMock, stream.argTypes(), "unedge", new Object[]{stream.argTypes()});
        Method result = subject.warp(InputStream.class, stream.edgeMethod());
        assertEquals(stream.realMethod(), result);
    }
}
