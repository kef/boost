package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sniper.inject.SubjectInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;

public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final MockSupport mocks;
    private final Injector subjectInjector = new SubjectInjector();
    private final Injector randominator;
    private final Injector mockinator;
    private final Injector dumminator;

    public DefaultTestFieldInjector(MockSupport mocks, Provider random) {
        this.mocks = mocks;
        randominator = new RandomsInjector(random);
        mockinator = new MockInjector(mocks);
        dumminator = new DummyInjector(mocks);
    }

    public void inject(Object ref) {
        mockinator.inject(ref);
        dumminator.inject(ref);
        randominator.inject(ref);
    }

    public void injectSubject(Object ref) {
        subjectInjector.inject(ref);
    }

    public void verify() {
        mocks.verify();
    }
}