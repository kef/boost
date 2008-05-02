package au.net.netstorm.boost.nursery.autoedge;

import java.net.URL;
import java.util.List;

import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeURLFixture;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

// FIX 2328 fixed it now, but I got caught out by a bug (i think) in test framework here
// FIX 2328 subject is package scoped and gets injected, then it gets injected with
// FIX 2328 real objects and not the mocks
public final class DefaultUnedgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Unedger subject;
    EdgeURLFixture fixture;
    AutoEdgeURL edgedObjectMock;
    List<?> realObjectMock;
    TypeTokenResolver typeResolverMock;
    TypeTokenInstance typeInstanceMock;

    public void setUpFixtures() {
        subject = new DefaultUnedger();
    }

    public void testUnedgeObjects() {
        expect.oneCall(edgedObjectMock, fixture.url(), "unedge");
        Object[] partialEdgedArgs = {edgedObjectMock, realObjectMock};
        Object[] result = subject.unedge(partialEdgedArgs);
        assertEquals(partialEdgedArgs.length, result.length);
        assertSame(fixture.url(), result[0]);
        assertSame(realObjectMock, result[1]);
    }

    public void testUnedgeNullObjects() {
        Object[] result = subject.unedge((Object[]) null);
        assertNull(result);
    }

    public void testUnedgeClasses() {
        expect.oneCall(typeResolverMock, typeInstanceMock, "resolve", AutoEdgeURL.class, new Object[]{Edge.class, StaticEdge.class});
        expect.oneCall(typeInstanceMock, URL.class, "rawType");
        Class<?>[] edgedClasses = {AutoEdgeURL.class, List.class};
        Class<?>[] result = subject.unedge(edgedClasses);
        assertEquals(edgedClasses.length, result.length);
        assertSame(URL.class, result[0]);
        assertSame(List.class, result[1]);
    }
}
