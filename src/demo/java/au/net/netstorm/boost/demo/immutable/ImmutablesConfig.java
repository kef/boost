package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.Web;

// FIX 2130 --- (Coordinate with MH) Move into "core"?
public final class ImmutablesConfig implements SpiderConfig {
    Web web;

    public void configure() {
        web.register(ImmutableFactory.class);
    }
}
