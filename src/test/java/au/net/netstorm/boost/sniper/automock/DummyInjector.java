package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.sniper.field.BoostField;
import au.net.netstorm.boost.sniper.field.BoostFieldBuilder;
import au.net.netstorm.boost.sniper.field.FieldBuilder;
import au.net.netstorm.boost.sniper.field.TestFieldSelector;
import au.net.netstorm.boost.sniper.matcher.DummyMatcher;
import au.net.netstorm.boost.sniper.matcher.Matcher;
import au.net.netstorm.boost.spider.inject.core.Injector;

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