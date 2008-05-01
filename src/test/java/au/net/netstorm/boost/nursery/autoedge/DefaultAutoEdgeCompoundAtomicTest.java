package au.net.netstorm.boost.nursery.autoedge;

import java.nio.channels.WritableByteChannel;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgeCompoundAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdge subject;
    private AutoEdge cosubject;

    EdgeChannelFixture fixture;

    MethodWarp warperMock;
    EdgeMethod invokerMock;
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdge(fixture.channel());
        cosubject = new DefaultAutoEdge(fixture.buffer());
    }

    public void testInvokeWithEdgedArgument() {
        WritableByteChannel channel = fixture.channel();
        Object[] edgedArgs = {cosubject};
        Object[] realArgs = {fixture.buffer()};

        expect.oneCall(warperMock, fixture.trg(), "warp", MockWritableByteChannel.class, fixture.src());
        expect.oneCall(invokerMock, fixture.length(), "invoke", fixture.trg(), channel, new Object[] { fixture.buffer() });
        expect.oneCall(unedgerMock, realArgs, "unedge", new Object[] {edgedArgs});

        Object length = subject.invoke(channel, fixture.src(), edgedArgs);
        assertEquals(fixture.length(), length);
    }
}
