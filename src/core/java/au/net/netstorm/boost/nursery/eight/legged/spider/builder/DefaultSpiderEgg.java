package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;
import au.net.netstorm.boost.spider.core.Spider;

public final class DefaultSpiderEgg implements SpiderEgg {
    private Spinneret spinneret = new DefaultSpinneret();
    public Spider hatch(WebConfig... configs) {
        SpidersWeb web = spinneret.spin(configs);
        return web.spider();
    }
}
