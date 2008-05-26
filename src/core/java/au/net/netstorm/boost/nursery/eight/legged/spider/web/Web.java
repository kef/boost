package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.spider.registry.Factory;

// FIX 2394 interface into mutable part of web state
public interface Web {
    void register(Rule... rules);
    void register(Factory... factory);
    void register(Provider... provider);
}
