package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.PartialInstances;
import au.net.netstorm.boost.spider.onion.layer.closure.TryCatchFinally;

public final class SpiderTryCatchFinally implements TryCatchFinally {
    PartialInstances resolved;

    public SpiderTryCatchFinally(PartialInstances resolved) {
        this.resolved = resolved;
    }

    public void theCore() {
        resolved.clear();
    }

    public void theFinally() {
        resolved.clear();
    }
}
