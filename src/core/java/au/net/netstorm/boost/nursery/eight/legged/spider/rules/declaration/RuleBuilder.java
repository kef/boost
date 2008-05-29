package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

interface RuleBuilder {
    Rule build();
    void setMapping(Factory factory);
    void setIsSingleton(boolean single);
    void setScope(Class<?> host, String name);
}
