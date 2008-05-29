package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.Matcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

interface RuleBuilder {
    KeyedRule build();
    void setMapping(Factory factory);
    void setIsSingleton(boolean single);
    void setScope(Matcher matcher);
}
