package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.TestFieldSelector;
import au.net.netstorm.boost.test.matcher.DummyMatcher;
import au.net.netstorm.boost.test.matcher.Matcher;

public final class DummyInjector implements Injector {
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private TestFieldSelector selector = new TestFieldSelector();
    private Matcher dummyMatcher = new DummyMatcher();
    private AutoMocker autoMocker;

    public DummyInjector(MockSupport mocks) {
        this.autoMocker = new DefaultAutoMocker(mocks);
    }

    public void inject(Object ref) {
        BoostField[] fields = fieldBuilder.build(ref);
        BoostField[] mockables = selector.select(fields, dummyMatcher);
        autoMocker.dummy(mockables);
    }
}