package au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;

public interface RuleBuilder {
    RulePattern type(Class<?> type);
    RulePattern pattern(Class<?> host, Class<?> type , String name);
    RulePattern pattern(InjectionPattern pattern);
}
