package au.net.netstorm.boost.gunge.automock;

import au.net.netstorm.boost.gunge.field.BoostField;
import au.net.netstorm.boost.gunge.field.BoostFieldBuilder;
import au.net.netstorm.boost.gunge.field.FieldBuilder;
import au.net.netstorm.boost.gunge.field.TestFieldSelector;
import au.net.netstorm.boost.gunge.matcher.Matcher;
import au.net.netstorm.boost.gunge.matcher.MockMatcher;
import au.net.netstorm.boost.spider.inject.core.Injector;

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
