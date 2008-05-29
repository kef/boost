package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import java.util.concurrent.atomic.AtomicReference;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class LazyRule implements Rule {
    private final AtomicReference<Rule> delegate = new AtomicReference<Rule>();
    private final RuleBuilder builder;

    public LazyRule(RuleBuilder builder) {
        this.builder = builder;
    }

    public Factory getFactory() {
        return rule().getFactory();
    }

    public boolean accepts(InjectionSite site) {
        return rule().accepts(site);
    }

    private Rule rule() {
        Rule rule = delegate.get();
        if (rule != null) return rule;
        rule = builder.build();
        delegate.compareAndSet(null, rule);
        return delegate.get();
    }
}
