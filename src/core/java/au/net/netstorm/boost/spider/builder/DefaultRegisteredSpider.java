package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.core.Spider;

public final class DefaultRegisteredSpider implements RegisteredSpider {
    private final Spider spider;
    private final Registry registry;

    public DefaultRegisteredSpider(Spider spider, Registry registry) {
        this.spider = spider;
        this.registry = registry;
    }

    public Spider spider() {
        return spider;
    }

    public Registry registry() {
        return registry;
    }
}
