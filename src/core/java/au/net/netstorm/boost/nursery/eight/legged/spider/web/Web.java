package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.RuleOrb;
import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.FactoryOrb;

// FIX 2394 interface into mutable part of web state
public interface Web {
    void register(RuleOrb... rules);
    void register(FactoryOrb... rules);
}
