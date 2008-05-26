package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.RuleOrb;
import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.FactoryOrb;

// FIX 2394 stateful web instance - a central state holder, rather than a buch of disparate maps
public interface Web {
    void register(RuleOrb... rules);
    void register(FactoryOrb... rules);
    Web spawn();
}
