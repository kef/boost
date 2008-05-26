package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.RuleOrb;

// FIX 2394 stateful web instance - a central state holder, rather than a buch of disparate maps
public interface Web {
    void register(RuleOrb... rules);
}
