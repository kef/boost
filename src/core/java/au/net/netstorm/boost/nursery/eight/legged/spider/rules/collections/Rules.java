package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public interface Rules extends Iterable<Rule> {
    void add(Rule rule);
    void addWildcard(Factory factory);
}
