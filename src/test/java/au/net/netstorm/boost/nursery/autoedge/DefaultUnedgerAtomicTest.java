package au.net.netstorm.boost.nursery.autoedge;

import java.util.List;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultUnedgerAtomicTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    Unedger subject;
    EdgeURLFixture fixture;
    AutoEdgeURL edgedObjectMock;
    List<?> realObjectMock;

    public void testUnedge() {
        expect.oneCall(edgedObjectMock, fixture.url(), "unedge");
        Object[] partialEdgedArgs = {edgedObjectMock, realObjectMock};
        Object[] result = subject.unedge(partialEdgedArgs);

        assertEquals(partialEdgedArgs.length, result.length);
        assertSame(fixture.url(), result[0]);
        assertSame(realObjectMock, result[1]);
    }

    public void testUnedgeNull() {
        Object[] result = subject.unedge(null);
        assertNull(result);
    }
}
