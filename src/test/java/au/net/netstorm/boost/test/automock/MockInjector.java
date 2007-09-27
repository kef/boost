package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.TestFieldSelector;
import au.net.netstorm.boost.test.matcher.Matcher;
import au.net.netstorm.boost.test.matcher.MockMatcher;

public final class MockInjector implements Injector {
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private TestFieldSelector selector = new TestFieldSelector();
    private Matcher mockMatcher = new MockMatcher();
    private AutoMocker autoMocker;

    public MockInjector(MockSupport mocks) {
        this.autoMocker = new DefaultAutoMocker(mocks);
    }

    public void inject(Object ref) {
        BoostField[] fields = fieldBuilder.build(ref);
        BoostField[] mockables = selector.select(fields, mockMatcher);
        autoMocker.mock(mockables);
    }
}
