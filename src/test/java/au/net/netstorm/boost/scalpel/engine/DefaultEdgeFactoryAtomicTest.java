package au.net.netstorm.boost.scalpel.engine;

import java.net.URL;
import java.util.List;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.scalpel.testdata.AutoEdgeURL;
import au.net.netstorm.boost.scalpel.testdata.java.util.ArrayList;
import au.net.netstorm.boost.scalpel.testdata.java.util.UnedgableList;
import au.net.netstorm.boost.scalpel.core.Unedgable;
import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

// FIX 2328 is this correct - test needs ArrayList declarations - looks like a bug in checkstyle anyway as they are not java.util.ArrayList's

// OK IllegalType {
public final class DefaultEdgeFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeFactory subject;
    URLFixture url;
    ProxySupplier proxierMock;
    Nu nuMock;
    AutoEdge edgeMock;
    AutoEdgeURL urlMock;
    ArrayList<?> arrayListMock;
    List<?> listMock;
    UnedgableList<?> unedgableListMock;

    public void setUpFixtures() {
        this.subject = new DefaultEdgeFactory();
    }

    public void testNu() {
        setProxyExpectations(AutoEdgeURL.class, urlMock, URL.class, url.real());
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, URL.class, url.real());
        assertSame(urlMock, result);
    }

    public void testCast() {
        setProxyExpectations(ArrayList.class, arrayListMock, java.util.ArrayList.class, listMock);
        expect.oneCall(unedgableListMock, listMock, "unedge");
        ArrayList<?> result = subject.cast(ArrayList.class, java.util.ArrayList.class, unedgableListMock);
        assertSame(arrayListMock, result);
    }

    private void setProxyExpectations(Class<?> edgeClass, Object edge, Class<?> realClass, Object real) {
        Object[] args = {realClass, real};
        Class<?>[] types = {edgeClass, Unedgable.class};
        ClassLoader loader = edgeClass.getClassLoader();
        expect.oneCall(nuMock, edgeMock, "nu", AutoEdge.class, args);
        expect.oneCall(proxierMock, edge, "getProxy", loader, types, edgeMock);
    }
}
// } IllegalType OK