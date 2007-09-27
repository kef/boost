package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.field.TestFieldSelector;
import au.net.netstorm.boost.test.matcher.Matcher;
import au.net.netstorm.boost.test.matcher.RandomMatcher;
import au.net.netstorm.boost.test.random.BoostFieldRandomizer;

public final class DefaultRandomsInjector implements Injector {
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final FieldSelector selector = new TestFieldSelector();
    private final Matcher randomMatcher = new RandomMatcher();
    private final BoostFieldRandomizer randomizer;

    public DefaultRandomsInjector(Provider random) {
        randomizer = new BoostFieldRandomizer(random);
    }

    public void inject(Object obj) {
        BoostField[] fields = fieldBuilder.build(obj);
        BoostField[] randoms = selector.select(fields, randomMatcher);
        randomizer.randomize(randoms);
    }
}
