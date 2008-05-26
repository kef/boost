package au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap;

import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.BlueprintedFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ImpliedFactory;

public final class BootstrapWebConfig implements WebConfig {
    public void apply(Web web) {
        web.register(BlueprintedFactory.class);
        web.register(ImpliedFactory.class);
        web.register(BootstrapFactory.class);
    }
}
