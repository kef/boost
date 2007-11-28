package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.inject.SubjectInjector;

public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final MockSupport mocks;
    private final Test test;
    private final Injector subjectInjector = new SubjectInjector();
    private final Injector randominator;
    private final Injector mockinator;
    private final Injector dumminator;

    public DefaultTestFieldInjector(Test test, MockSupport mocks, Provider random) {
        this.test = test;
        this.mocks = mocks;
        randominator = new RandomsInjector(random);
        mockinator = new MockInjector(mocks);
        dumminator = new DummyInjector(mocks);
    }

    public void inject() {
        mockinator.inject(test);
        dumminator.inject(test);
        randominator.inject(test);
    }

    public void injectSubject() {
        subjectInjector.inject(test);
    }

    public void verify() {
        mocks.verify();
    }
}