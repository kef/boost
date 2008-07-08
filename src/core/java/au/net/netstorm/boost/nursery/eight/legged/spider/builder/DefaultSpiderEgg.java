package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.spider.core.Spider;

public final class DefaultSpiderEgg implements SpiderEgg {
    public Spider hatch(Class<? extends SpiderConfig>... configs) {
        Bootstrapper bootstrapper = new DefaultBootstrapper();
        return bootstrapper.bootstrap(configs);
    }
}
