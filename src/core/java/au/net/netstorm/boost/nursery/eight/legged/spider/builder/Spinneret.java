package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;

public interface Spinneret {
    SpidersWeb spin(WebConfig... configs);
}
