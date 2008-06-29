package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;

public interface Spinneret {
    SpidersWeb spin(WebConfig... configs);
}
