package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.Edge;
import au.net.netstorm.boost.edge.core.StaticEdge;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

import java.net.URL;
import java.util.List;

public final class DefaultUnedgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Unedger subject;
    private URLFixture fixture;
    Unedgable edgedObjectMock;
    List<?> realObjectMock;
    TypeResolver typeResolverMock;
    TypeInstance typeInstanceMock;

    public void setUpFixtures() {
        subject = new DefaultUnedger();
        fixture = new URLFixture();
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
        expect.oneCall(typeResolverMock, typeInstanceMock, "resolve", AutoEdgeURL.class, new Object[]{Edge.class, StaticEdge.class});
        expect.oneCall(typeInstanceMock, URL.class, "raw");
        Class<?>[] edgedClasses = {AutoEdgeURL.class, List.class};
        Class<?>[] result = subject.unedge(edgedClasses);
        assertEquals(edgedClasses.length, result.length);
        assertSame(URL.class, result[0]);
        assertSame(List.class, result[1]);
    }
}
