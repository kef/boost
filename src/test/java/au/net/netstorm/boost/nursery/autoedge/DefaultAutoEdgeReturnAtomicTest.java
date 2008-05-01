package au.net.netstorm.boost.nursery.autoedge;

import java.nio.ByteBuffer;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeByteBuffer;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeBufferFixture;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgeReturnAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdge subject;
    EdgeBufferFixture fixture;

    MethodWarp warperMock;
    EdgeMethod invokerMock;
    Unedger unedgerMock;
    AutoEdger edgerMock;
    AutoEdgeByteBuffer bufferMock;


    public void setUpFixtures() {
        subject = new DefaultAutoEdge(ByteBuffer.class, fixture.buffer());
    }

    public void testInvokeWithEdgedReturnType() {
        expect.oneCall(warperMock, fixture.trg(), "warp", ByteBuffer.class, fixture.src());
        expect.oneCall(invokerMock, fixture.buffer(), "invoke", fixture.trg(), fixture.buffer(), (Object) null);
        expect.oneCall(unedgerMock, VOID, "unedge", (Object) null);
        expect.oneCall(edgerMock, bufferMock, "edge", AutoEdgeByteBuffer.class, fixture.buffer());
        Object result = subject.invoke(fixture.buffer(), fixture.src(), null);
        assertEquals(bufferMock, result);
    }
}
