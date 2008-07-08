package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.spider.core.Spider;

public interface Bootstrapper {
    Spider bootstrap(Class<? extends SpiderConfig>[] configs);
}
