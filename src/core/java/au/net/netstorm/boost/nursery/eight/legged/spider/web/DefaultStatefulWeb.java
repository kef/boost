package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Graph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.RuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.DefaultRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.DefaultRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.multiplicity.Multiplicity;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.DefaultFactories;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factories;

public final class DefaultStatefulWeb implements StatefulWeb {
    // FIX BREADCRUMB 2394 aaaaaaaa add state fields
    private final Factories factories = new DefaultFactories();
    private final Rules rules = new DefaultRules();


    public <T> Graph<T> build(Class<T> root) {
        throw new UnsupportedOperationException();
    }

    public void register(Rule rules) {
        throw new UnsupportedOperationException();
    }

    public void register(Class<? extends Factory> factory) {
        throw new UnsupportedOperationException();
    }

    public void register(Factory factory) {
        throw new UnsupportedOperationException();
    }

    public RuleBuilder bind(Multiplicity multiplicity) {
        return new DefaultRuleBuilder(this, multiplicity);
    }
}
