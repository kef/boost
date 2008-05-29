package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;

public final class DefaultRuler implements Ruler {
    private final InjectionTypeBuilder typeBuilder = new DefaultInjectionTypeBuilder();
    private final Rules rules;

    public DefaultRuler(Rules rules) {
        this.rules = rules;
    }

    public Mapping map(Class<?> iface) {
        InjectionType type = typeBuilder.build(iface);
        return map(type);
    }

    public Mapping map(InjectionType type) {
        RuleBuilder builder = new DefaultRuleBuilder(type);
        Rule rule = new LazyRule(builder);
        rules.add(rule);
        return new DefaultMapping(builder);
    }
}
