package au.net.netstorm.boost.gunge.automock;

import au.net.netstorm.boost.gunge.field.BoostField;
import au.net.netstorm.boost.gunge.field.BoostFieldBuilder;
import au.net.netstorm.boost.gunge.field.FieldBuilder;
import au.net.netstorm.boost.gunge.field.FieldSelector;
import au.net.netstorm.boost.gunge.field.TestFieldSelector;
import au.net.netstorm.boost.gunge.matcher.Matcher;
import au.net.netstorm.boost.gunge.matcher.RandomMatcher;
import au.net.netstorm.boost.gunge.random.BoostFieldRandomizer;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;

public final class RandomsInjector implements Injector {
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final FieldSelector selector = new TestFieldSelector();
    private final Matcher randomMatcher = new RandomMatcher();
    private final BoostFieldRandomizer randomizer;

    public RandomsInjector(Provider random) {
        randomizer = new BoostFieldRandomizer(random);
    }

    public void inject(Object obj) {
        BoostField[] fields = fieldBuilder.build(obj);
        BoostField[] randoms = selector.select(fields, randomMatcher);
        randomizer.randomize(randoms);
    }
}
