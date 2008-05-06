package au.net.netstorm.boost.edge;

import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.edge.testfixtures.EdgeURLFixture;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.gunge.reflect.ConstructorResolver;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultRealNuAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private RealNu subject;
    EdgeURLFixture fixture;

    ConstructorResolver resolverMock;
    EdgeConstructor constructorMock;
    TypeResolver typeResolverMock;
    TypeInstance typeTokenMock;
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultRealNu();
    }

    public void testNu() {
        Object[] args = {fixture.value()};
        expect.oneCall(typeResolverMock, typeTokenMock, "resolve", AutoEdgeURL.class, new Object[]{Edge.class});
        expect.oneCall(typeTokenMock, URL.class, "raw");
        expect.oneCall(resolverMock, fixture.constructor(), "resolve", URL.class, args);
        expect.oneCall(unedgerMock, args, "unedge", new Object[]{args});
        expect.oneCall(constructorMock, fixture.url(), "newInstance", fixture.constructor(), args);
        subject.nu(AutoEdgeURL.class, fixture.value());
    }
}
