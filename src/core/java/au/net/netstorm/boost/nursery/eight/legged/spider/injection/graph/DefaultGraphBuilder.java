package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factories;

public final class DefaultGraphBuilder implements GraphBuilder {
    private final Rules rules;
    private final Factories factories;

    public DefaultGraphBuilder(Rules rules, Factories factories) {
        this.rules = rules;
        this.factories = factories;
    }

    public RootInjection build(Class<?> root) {
        throw new UnsupportedOperationException();
    }
}
