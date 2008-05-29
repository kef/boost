package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.core.Spider;

public interface RegisteredSpider {
    Registry registry();
    Spider spider();
}
