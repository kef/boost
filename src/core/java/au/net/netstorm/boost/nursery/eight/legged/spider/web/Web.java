package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;

public interface Web {
    void register(RuleConfig ruleConfig);
    void register(Class<? extends Factory> type);
    void register(Factory factory);
    Binder binder();
}
