package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.onion.layer.closure.TryFinally;

public final class SpiderTryFinally implements TryFinally {
    ResolvedThings resolvedThings;

    public SpiderTryFinally(ResolvedThings resolvedThings) {
        this.resolvedThings = resolvedThings;
    }

    public void in() {
        resolvedThings.clear();
    }

    public void out() {
        resolvedThings.clear();
    }
}
