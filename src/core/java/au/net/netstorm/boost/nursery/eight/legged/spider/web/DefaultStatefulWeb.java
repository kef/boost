package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Graph;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.RuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.DefaultRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.spider.registry.Factory;

public final class DefaultStatefulWeb implements StatefulWeb {
    public <T> Graph<T> build(Class<T> root) {
        throw new UnsupportedOperationException();
    }

    public void register(Rule... rules) {
        throw new UnsupportedOperationException();
    }

    public void register(Factory... factory) {
        throw new UnsupportedOperationException();
    }

    public void register(Provider... provider) {
        throw new UnsupportedOperationException();
    }

    public RuleBuilder bind() {
        return new DefaultRuleBuilder(this);
    }
}
