package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;

public final class DefaultRuler implements Ruler {
    private final Rules rules;

    public DefaultRuler(Rules rules) {
        this.rules = rules;
    }

    public Mapping map(Class<?> iface) {
        throw new UnsupportedOperationException();
    }

    public Mapping map(InjectionType type) {
        throw new UnsupportedOperationException();
    }
}
