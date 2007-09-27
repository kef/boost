package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.core.CleanTestCase;
import au.net.netstorm.boost.test.inject.SubjectInjector;

public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final MockSupport mocks;
    private final CleanTestCase testCase;
    private final Injector subjectInjector = new SubjectInjector();
    private final Injector randominator;
    private final Injector mockinator;
    private final Injector dumminator;

    public DefaultTestFieldInjector(CleanTestCase testCase, MockSupport mocks, Provider random) {
        this.testCase = testCase;
        this.mocks = mocks;
        randominator = new RandomsInjector(random);
        mockinator = new MockInjector(mocks);
        dumminator = new DummyInjector(mocks);
    }

    public void inject() {
        mockinator.inject(testCase);
        dumminator.inject(testCase);
        randominator.inject(testCase);
    }

    public void injectSubject() {
        subjectInjector.inject(testCase);
    }

    public void verify() {
        mocks.verify();
    }
}