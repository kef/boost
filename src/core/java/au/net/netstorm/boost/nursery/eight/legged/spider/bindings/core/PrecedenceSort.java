package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import java.util.Comparator;

public final class PrecedenceSort implements Comparator<Binding> {
    public int compare(Binding b1, Binding b2) {
        Precedence p1 = b1.getPrecedence();
        Precedence p2 = b2.getPrecedence();
        return p1.compareTo(p2);
    }
}
