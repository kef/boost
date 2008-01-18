package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.inject.SubjectInjector;

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