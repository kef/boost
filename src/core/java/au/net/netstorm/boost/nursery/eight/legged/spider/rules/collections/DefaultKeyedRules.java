package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;

public final class DefaultKeyedRules implements KeyedRules {
    private final StrictMap<InjectionType, List<KeyedRule>> rules =
            new DefaultStrictMap<InjectionType, List<KeyedRule>>();

    public boolean exists(InjectionType type) {
        if (rules.exists(type)) return true;
        InjectionType raw = type.raw();
        return rules.exists(raw);
    }
}
