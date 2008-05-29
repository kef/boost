package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

// FIX 2394 experiment in a tidy way to build rules (to part)
public interface RuleTarget {
    // FIX 2394 maybe "by" or "providedBy" would be better than "to"
    RuleScope to(Factory factory);
    RuleScope to(Provider provider);
    RuleScope to(Object instance);
    RuleScope to(Class<?> impl);
}
