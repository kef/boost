package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;

// FIX 2394 stateful web instance - a central state holder, rather than a bunch of disparate maps
public interface Web {
    void register(RuleConfig ruleConfig);
    // FIX 2394 assuming that these are wildcard factories only, other factories set by rules
    void register(Class<? extends Factory> type);
    void register(Factory factory);
}
