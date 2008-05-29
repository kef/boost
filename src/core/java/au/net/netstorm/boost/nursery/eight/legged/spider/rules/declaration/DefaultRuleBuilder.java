package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class DefaultRuleBuilder implements RuleBuilder {
    public Rule build() {
        throw new UnsupportedOperationException();
    }

    public void setMapping(Factory factory) {
        throw new UnsupportedOperationException();
    }

    public void setIsSingleton() {
        throw new UnsupportedOperationException();
    }

    public void setScope(Class<?> host, String name) {
        throw new UnsupportedOperationException();
    }
}
