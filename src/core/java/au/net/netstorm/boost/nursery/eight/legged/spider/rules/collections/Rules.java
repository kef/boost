package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;

public interface Rules extends Iterable<Rule> {
    void add(Rule rule);
}
