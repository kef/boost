package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;

public interface Spinneret {
    SpiderEgg spin(Class<? extends SpiderConfig>... configs);
}
