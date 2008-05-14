package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sniper.inject.SubjectInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;

public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final MockSupport mocks;
    private final Injector subjectinator;
    private final Injector randominator;
    private final Injector mockinator;
    private final Injector dumminator;
    // FIX 2328 add real injector that knows about subjects
//    private final Injector realinator;

    public DefaultTestFieldInjector(MockSupport mocks, Provider random) {
        this.mocks = mocks;
        randominator = new RandomsInjector(random);
        mockinator = new MockInjector(mocks);
        dumminator = new DummyInjector(mocks);
        subjectinator = new SubjectInjector();
//        realinator = new RealInjector();
    }

    public void injectTestDoubles(Object ref) {
        mockinator.inject(ref);
        dumminator.inject(ref);
        randominator.inject(ref);
    }

    public void injectSubject(Object ref) {
        subjectinator.inject(ref);
    }

    // FIX 2328 add method to inject reals and wire into InjectTest
    public void injectReals(Object ref) {

    }

    public void verify() {
        mocks.verify();
    }
}