package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.core.BoooostCase;
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
import au.net.netstorm.boost.test.matcher.RandomMatcher;
import au.net.netstorm.boost.test.random.BoostFieldRandomizer;
import au.net.netstorm.boost.test.random.Randomizer;

// DEBT DataAbstractionCoupling {
public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final FieldSelector selector = new TestFieldSelector();
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final Matcher randomMatcher = new RandomMatcher();
    private final Matcher mockMatcher = new MockMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final MockSupport mocks;
    private final Randomizer randomizer;
    private final BoooostCase testCase;
    private final AutoMocker autoMocker;

    public DefaultTestFieldInjector(BoooostCase testCase, MockSupport mocks, Provider random) {
        this.testCase = testCase;
        this.mocks = mocks;
        randomizer = new BoostFieldRandomizer(random);
        autoMocker = new DefaultAutoMocker(mocks);
    }

    public void inject() {
        BoostField[] fields = getAllFields();
        injectMocks(fields);
        injectDummies(fields);
        injectRandoms(fields);
    }

    public void injectSubject() {
        subjectInjector.inject(testCase);
    }

    public void verify() {
        mocks.verify();
    }

    private void injectMocks(BoostField[] fields) {
        BoostField[] mockables = selector.select(fields, mockMatcher);
        autoMocker.mock(mockables);
    }

    private void injectDummies(BoostField[] fields) {
        BoostField[] dummies = selector.select(fields, dummyMatcher);
        autoMocker.dummy(dummies);
    }

    private void injectRandoms(BoostField[] fields) {
        BoostField[] randoms = selector.select(fields, randomMatcher);
        randomizer.randomize(randoms);
    }

    private BoostField[] getAllFields() {
        return fieldBuilder.build(testCase);
    }
}
// } DEBT DataAbstractionCoupling