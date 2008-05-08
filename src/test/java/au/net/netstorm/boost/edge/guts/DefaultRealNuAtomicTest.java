package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.Edge;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.gunge.reflect.ConstructorResolver;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

import java.net.URL;

public final class DefaultRealNuAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private RealNu subject;
    private URLFixture fixture;
    ConstructorResolver resolverMock;
    EdgeConstructor constructorMock;
    TypeResolver typeResolverMock;
    TypeInstance typeTokenMock;
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultRealNu();
        fixture = new URLFixture();
    }

    public void testNu() {
        Object[] args = {fixture.arg()};
        expect.oneCall(typeResolverMock, typeTokenMock, "resolve", AutoEdgeURL.class, new Object[]{Edge.class});
        expect.oneCall(typeTokenMock, URL.class, "raw");
        expect.oneCall(resolverMock, fixture.constructor(), "resolve", URL.class, args);
        expect.oneCall(unedgerMock, args, "unedge", new Object[]{args});
        expect.oneCall(constructorMock, fixture.real(), "newInstance", fixture.constructor(), args);
        subject.nu(AutoEdgeURL.class, fixture.arg());
    }
}
