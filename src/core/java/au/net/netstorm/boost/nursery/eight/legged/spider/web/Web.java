package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;

public interface Web {
    void configure(Class<? extends SpiderConfig> config);
    void configure(SpiderConfig config);
    // FIX BREADCRUMB 2394 bbbbb killing this
    void register(RuleConfig ruleConfig);
    void register(Class<? extends Factory> type);
    void register(Factory factory);
    Binder binder();
}
