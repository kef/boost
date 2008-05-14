package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sniper.inject.SubjectInitializer;
import au.net.netstorm.boost.sniper.inject.SubjectInjector;
import au.net.netstorm.boost.spider.inject.core.Injector;

public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final MockSupport mocks;
    private final Injector subjectinator;
    private final Injector randominator;
    private final Injector mockinator;
    private final Injector dumminator;
    private final Injector nusubject;

    public DefaultTestFieldInjector(MockSupport mocks, Provider random) {
        this.mocks = mocks;
        randominator = new RandomsInjector(random);
        mockinator = new MockInjector(mocks);
        dumminator = new DummyInjector(mocks);
        subjectinator = new SubjectInjector();
        nusubject = new SubjectInitializer();
    }

    public void injectTestDoubles(Object ref) {
        mockinator.inject(ref);
        dumminator.inject(ref);
        randominator.inject(ref);
    }                                         

    public void initSubject(Object ref) {
        nusubject.inject(ref);
    }

    public void injectSubject(Object ref) {
        subjectinator.inject(ref);
    }

    public void verify() {
        mocks.verify();
    }
}