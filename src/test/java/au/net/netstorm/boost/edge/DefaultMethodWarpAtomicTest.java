package au.net.netstorm.boost.edge;

import java.io.InputStream;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.testfixtures.EdgeChannelFixture;
import au.net.netstorm.boost.edge.testfixtures.EdgeStreamFixture;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMethodWarpAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private MethodWarp subject;

    EdgeChannelFixture channel;
    EdgeStreamFixture stream;

    EdgeClass classerMock;
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultMethodWarp();
    }

    public void testWarp() {
        expect.oneCall(classerMock, stream.real(), "getMethod", InputStream.class, stream.method(), stream.types());
        expect.oneCall(unedgerMock, stream.types(), "unedge", new Object[]{stream.types()});
        Method result = subject.warp(InputStream.class, stream.edge());
        assertEquals(stream.real(), result);
    }
}
