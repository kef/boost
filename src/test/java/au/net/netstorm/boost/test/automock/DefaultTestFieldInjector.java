package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.core.CleanTestCase;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.field.TestFieldSelector;
import au.net.netstorm.boost.test.inject.DefaultSubjectInjector;
import au.net.netstorm.boost.test.inject.SubjectInjector;
import au.net.netstorm.boost.test.matcher.DummyMatcher;
import au.net.netstorm.boost.test.matcher.Matcher;
import au.net.netstorm.boost.test.matcher.MockMatcher;

// DEBT DataAbstractionCoupling {
public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final FieldSelector selector = new TestFieldSelector();
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final Matcher mockMatcher = new MockMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final MockSupport mocks;
    private final CleanTestCase testCase;
    private final AutoMocker autoMocker;
    private final Injector randomer;

    public DefaultTestFieldInjector(CleanTestCase testCase, MockSupport mocks, Provider random) {
        this.testCase = testCase;
        this.mocks = mocks;
        autoMocker = new DefaultAutoMocker(mocks);
        randomer = new RandomsInjector(random);
    }

    public void inject() {
        injectMocks();
        injectDummies();
        injectRandoms();
    }

    public void injectSubject() {
        subjectInjector.inject(testCase);
    }

    public void verify() {
        mocks.verify();
    }

    private void injectMocks() {
        BoostField[] fields = fieldBuilder.build(testCase);
        BoostField[] mockables = selector.select(fields, mockMatcher);
        autoMocker.mock(mockables);
    }

    private void injectDummies() {
        BoostField[] fields = fieldBuilder.build(testCase);
        BoostField[] dummies = selector.select(fields, dummyMatcher);
        autoMocker.dummy(dummies);
    }

    private void injectRandoms() {
        randomer.inject(testCase);
    }
}
// } DEBT DataAbstractionCoupling