package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.onion.layer.closure.TryCatchFinally;

public final class SpiderTryCatchFinally implements TryCatchFinally {
    ResolvedThings resolved;

    public SpiderTryCatchFinally(ResolvedThings resolved) {
        this.resolved = resolved;
    }

    public void theCore() {
        resolved.clear();
    }

    public void theFinally() {
        resolved.clear();
    }
}
