package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;

public interface Web {
    void configure(Class<? extends SpiderConfig> config);
    void register(Class<? extends Factory> type);
    Binder binder();
}
