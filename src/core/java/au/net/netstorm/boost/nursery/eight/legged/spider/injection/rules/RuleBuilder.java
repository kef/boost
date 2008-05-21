package au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.multiplicity.Multiplicity;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;

public interface RuleBuilder {
    Rule rule(InjectionPattern pattern, Multiplicity multiplicity, RuleType type);
}
