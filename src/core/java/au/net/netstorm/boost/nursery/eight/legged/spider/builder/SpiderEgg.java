package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;

public interface SpiderEgg {
    Spider hatch(WebConfig... configs);
}
