package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.Web;
import au.net.netstorm.boost.spider.core.Spider;

public final class DefaultSpiderEgg implements SpiderEgg {
    private final Web web;
    private final Spider spider;

    public DefaultSpiderEgg(Web web, Spider spider) {
        this.web = web;
        this.spider = spider;
    }

    public Spider hatch() {
        return spider;
    }

    public Web spin() {
        return web;
    }
}
