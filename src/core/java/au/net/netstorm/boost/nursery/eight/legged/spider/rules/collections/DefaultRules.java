package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import java.util.Iterator;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2394 implement me
public final class DefaultRules implements Rules {
    // FIX 2394 wildcarded rules need to be traversed reverse of insertion order

    public void add(Rule rule) {
        // FIX 2394 check if it is a keyed rule and go ahead and go
        throw new UnsupportedOperationException();
    }

    public void addWildcard(Factory factory) {
        throw new UnsupportedOperationException();
    }

    public Iterator<Rule> iterator() {
        throw new UnsupportedOperationException();
    }
}
