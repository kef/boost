package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.instance.PartialInstances;
import au.net.netstorm.boost.spider.onion.layer.closure.TryFinally;

public final class SpiderTryFinally implements TryFinally {
    PartialInstances resolved;

    public SpiderTryFinally(PartialInstances resolved) {
        this.resolved = resolved;
    }

    public void theCore() {
        resolved.clear();
    }

    public void theFinally() {
        resolved.clear();
    }
}
