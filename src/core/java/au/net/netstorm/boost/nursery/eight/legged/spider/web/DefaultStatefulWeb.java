package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.FactoryOrb;
import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.RuleOrb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Graph;

public final class DefaultStatefulWeb implements StatefulWeb {
    public void register(RuleOrb... rules) {
        throw new UnsupportedOperationException();
    }

    public void register(FactoryOrb... rules) {
        throw new UnsupportedOperationException();
    }

    public <T> Graph<T> build(Class<T> root) {
        throw new UnsupportedOperationException();
    }
}
