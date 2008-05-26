package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;

// FIX 2394 experiment in a tidy way to build rules (from part)
public interface RuleBuilder {
    RulePattern type(Class<?> type);
    RulePattern pattern(Class<?> host, Class<?> type, String name);
    RulePattern pattern(InjectionPattern pattern);
}
