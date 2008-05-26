package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.FactoryOrb;
import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.RuleOrb;

public final class DefaultWeb implements Web {
    public void register(RuleOrb... rules) {
        throw new UnsupportedOperationException();
    }

    public void register(FactoryOrb... rules) {
        throw new UnsupportedOperationException();
    }

    public Web spawn() {
        throw new UnsupportedOperationException();
    }
}
