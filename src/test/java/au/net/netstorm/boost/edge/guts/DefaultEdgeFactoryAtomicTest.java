package au.net.netstorm.boost.edge.guts;

import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultEdgeFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeFactory subject;
    private URLFixture url;
    EdgeValidator validatorMock;
    ProxySupplier proxierMock;
    Types typesMock;
    AutoEdge edgeMock;
    AutoEdgeURL urlMock;

    public void setUpFixtures() {
        this.subject = new DefaultEdgeFactory();
        url = new URLFixture();
    }

    public void testNu() {
        Object[] args = {URL.class , url.real()};
        Class<?>[] types = {AutoEdgeURL.class, Unedgable.class};
        ClassLoader loader = AutoEdgeURL.class.getClassLoader();
        expect.oneCall(typesMock, edgeMock, "nu", AutoEdge.class, args);
        expect.oneCall(proxierMock, urlMock, "getProxy", loader, types, edgeMock);
        expect.oneCall(validatorMock, VOID, "validate", AutoEdgeURL.class, URL.class);
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, URL.class, url.real());
        assertSame(urlMock, result);
    }
}
