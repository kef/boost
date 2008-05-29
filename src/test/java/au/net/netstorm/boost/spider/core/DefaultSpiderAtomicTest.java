package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultSpiderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Spider subject;
    private Testy testy = new Testy();
    Nu nuMock;
    Injector injectorMock;
    Resolver resolverMock;

    public void setUpFixtures() {
        subject = new DefaultSpider(nuMock, injectorMock, resolverMock);
    }

    public void testNu() {
        expect.nu(testy, Testy.class);
        Testy result = subject.nu(Testy.class);
        assertSame(testy, result);
    }

    public void testInject() {
        Testy testy = new Testy();
        expect.oneCall(injectorMock, VOID, "inject", testy);
        subject.inject(testy);
    }

     public void testResolve() {
        expect.oneCall(resolverMock, testy, "resolve", Testy.class);
        Testy result = subject.resolve(Testy.class);
        assertSame(testy, result);
    }

    static class Testy {}
}