package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.spider.core.Spider;

public interface SpiderEgg {
    Spider hatch(WebConfig... configs);
}
