package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.RuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.multiplicity.Multiplicity;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2394 interface into mutable part of web state
public interface Web {
    void register(Rule rule);
    void register(Class<? extends Factory> factory);
    void register(Factory factory);
    void register(Provider provider);

    // FIX 2394 bit of an experiment in seperating three roles in defining rules
    // FIX 2394 still to decide if it works well or not
    RuleBuilder bind(Multiplicity multiplicity);
}
