package au.net.netstorm.boost.edge.guts;

import java.net.URL;
import au.net.netstorm.boost.gunge.reflect.ConstructorResolver;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultRealNuAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private RealNu subject;
    URLFixture fixture;
    ConstructorResolver resolverMock;
    EdgeConstructor constructorMock;
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultRealNu();
    }

    public void testNu() {
        Object[] args = {fixture.arg()};
        expect.oneCall(resolverMock, fixture.constructor(), "resolve", URL.class, args);
        expect.oneCall(unedgerMock, args, "unedge", new Object[]{args});
        expect.oneCall(constructorMock, fixture.real(), "newInstance", fixture.constructor(), args);
        URL result = subject.nu(URL.class, fixture.arg());
        assertEquals(fixture.real(), result);
    }
}
