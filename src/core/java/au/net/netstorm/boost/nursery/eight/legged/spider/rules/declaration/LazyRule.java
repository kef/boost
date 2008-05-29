package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import java.util.concurrent.atomic.AtomicReference;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2394 should be a keyed rule
public final class LazyRule implements KeyedRule {
    private final AtomicReference<KeyedRule> delegate = new AtomicReference<KeyedRule>();
    private final RuleBuilder builder;

    public LazyRule(RuleBuilder builder) {
        this.builder = builder;
    }

    public InjectionType key() {
        return rule().key();
    }

    public Factory getFactory() {
        return rule().getFactory();
    }

    public boolean accepts(InjectionSite site) {
        return rule().accepts(site);
    }

    private KeyedRule rule() {
        KeyedRule rule = delegate.get();
        if (rule != null) return rule;
        rule = builder.build();
        delegate.compareAndSet(null, rule);
        return delegate.get();
    }
}
