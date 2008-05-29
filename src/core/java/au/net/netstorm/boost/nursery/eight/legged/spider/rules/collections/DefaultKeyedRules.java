package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;

// FIX 2394 i think this is the correct place to fall back on raw types
// FIX 2394 the implementation is just a bit of a mess at the moment
public final class DefaultKeyedRules implements KeyedRules {
    private final StrictMap<InjectionType, List<KeyedRule>> rules =
            new DefaultStrictMap<InjectionType, List<KeyedRule>>();

    public boolean exists(InjectionType type) {
        if (rules.exists(type)) return true;
        // FIX 2394 do i really want to fallback, if you can't bind the specific type then don't try at all???
        InjectionType raw = type.raw();
        return rules.exists(raw);
    }

    public Iterable<KeyedRule> get(InjectionType type) {
        if (rules.exists(type)) return rules.get(type);
        InjectionType raw = type.raw();
        return rules.get(raw);
    }
}
