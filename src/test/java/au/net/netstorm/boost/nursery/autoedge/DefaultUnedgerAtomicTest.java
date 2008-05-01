package au.net.netstorm.boost.nursery.autoedge;

import java.net.URL;
import java.util.List;

import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeURLFixture;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultUnedgerAtomicTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    Unedger subject;
    EdgeURLFixture fixture;
    AutoEdgeURL edgedObjectMock;
    List<?> realObjectMock;
    TypeTokenResolver typeResolverMock;

    public void testUnedgeObjects() {
        expect.oneCall(edgedObjectMock, fixture.url(), "unedge");
        Object[] partialEdgedArgs = {edgedObjectMock, realObjectMock};
        Object[] result = subject.unedge(partialEdgedArgs);

        assertEquals(partialEdgedArgs.length, result.length);
        assertSame(fixture.url(), result[0]);
        assertSame(realObjectMock, result[1]);
    }

    public void testUnedgeNullObjects() {
        Object[] result = subject.unedge((Object[])null);
        assertNull(result);
    }

    public void testUnedgeClasses() {
        Class<?>[] edgedClasses = {AutoEdgeURL.class,List.class};
        Class<?>[] result = subject.unedge(edgedClasses);

        assertEquals(edgedClasses.length, result.length);
        assertSame(URL.class, result[0]);
        assertSame(List.class, result[1]);
    }
}
