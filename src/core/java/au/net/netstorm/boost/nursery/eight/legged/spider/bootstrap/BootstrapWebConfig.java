package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.StatefulWeb;

public final class BootstrapWebConfig implements WebConfig {
    public BootstrapWebConfig(StatefulWeb web) {
        throw new UnsupportedOperationException();
    }

    public void apply(Web web) {
        // FIX 2394 something like
//        web.register(new BlueprintsFactory());
//        web.register(new ImplicitFactory());
//        web.register(new EdgeFactory());
//        web.register(new BootstrapFactory());
    }
}
