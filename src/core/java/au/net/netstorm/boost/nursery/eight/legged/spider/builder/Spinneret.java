package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;

// FIX 2394 spins webs
public interface Spinneret {
    Web spin(WebConfig... configs);
}
