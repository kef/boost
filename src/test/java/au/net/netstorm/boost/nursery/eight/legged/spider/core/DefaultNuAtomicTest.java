package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultNuAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Nu subject;
    NuObjectGraph nuGraphMock;
    Ball ballMock;

    public void setUpFixtures() {
        subject = new DefaultNu(nuGraphMock);
    }

    public void testNu() {
        expect.oneCall(nuGraphMock, ballMock, "nu", Ball.class, new Object[0]);
        Ball result = subject.nu(Ball.class);
        assertSame(ballMock, result);
    }
}
