package au.net.netstorm.boost.edge.guts;

import java.net.URL;
import java.util.List;

import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultUnedgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Unedger subject;
    URLFixture fixture;
    Unedgable edgedObjectMock;
    List<?> realObjectMock;
    EdgeMapper mapperMock;

    public void setUpFixtures() {
        subject = new DefaultUnedger();
    }

    public void testUnedgeObjects() {
        expect.oneCall(edgedObjectMock, fixture.real(), "unedge");
        Object[] partialEdgedArgs = {edgedObjectMock, realObjectMock};
        Object[] result = subject.unedge(partialEdgedArgs);
        assertEquals(partialEdgedArgs.length, result.length);
        assertSame(fixture.real(), result[0]);
        assertSame(realObjectMock, result[1]);
    }

    public void testUnedgeNullObjects() {
        Object[] result = subject.unedge((Object[]) null);
        assertNull(result);
    }

    public void testUnedgeClasses() {
        expect.oneCall(mapperMock, URL.class, "edgeToReal", AutoEdgeURL.class);
        Class<?>[] edgedClasses = {AutoEdgeURL.class, List.class};
        Class<?>[] result = subject.unedge(edgedClasses);
        assertEquals(edgedClasses.length, result.length);
        assertSame(URL.class, result[0]);
        assertSame(List.class, result[1]);
    }
}
