package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.WildcardRule;

public final class DefaultWildcardRules implements WildcardRules {
    private List<WildcardRule> rules = new ArrayList<WildcardRule>();

    public Iterator<WildcardRule> iterator() {
        return rules.iterator();
    }
}
