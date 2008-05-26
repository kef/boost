package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.RuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2394 stateful web instance - a central state holder, rather than a bunch of disparate maps
public interface Web {
    void register(Rule rule);
    void register(Class<? extends Factory> type);
    void register(Factory factory);

    // FIX 2394 bit of an experiment in seperating three roles in defining rules
    // FIX 2394 still to decide if it works well or not

    // FIX 2394 one good alternative is to have an interface which takes a RuleBuilder which has all the operations
    RuleBuilder single();
    RuleBuilder multi();
}
