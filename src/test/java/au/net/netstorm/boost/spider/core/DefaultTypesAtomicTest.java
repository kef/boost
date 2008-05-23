package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.resolve.ImplementationLookup;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class DefaultTypesAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Nu subject;
    ImplementationLookup lookupMock;
    NuImpl nuImplMock;
    Rock rockMock;

    public void setUpFixtures() {
        subject = new DefaultNu(lookupMock, nuImplMock);
    }

    public void testNu() {
        expect.oneCall(lookupMock, SmoothRock.class, "getImplementation", Rock.class);
        expect.oneCall(nuImplMock, rockMock, "nu", SmoothRock.class, new Object[0]);
        Rock result = subject.nu(Rock.class);
        assertSame(rockMock, result);
    }
}
