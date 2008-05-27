package au.net.netstorm.boost.nursery.eight.legged.spider.rules.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface KeyedRule extends Rule {
    InjectionType key();
}
