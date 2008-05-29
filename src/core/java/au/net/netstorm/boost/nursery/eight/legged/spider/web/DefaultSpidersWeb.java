package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.spider.core.Spider;

public final class DefaultSpidersWeb implements SpidersWeb {
    private final Web web;
    private final Spider spider;

    public DefaultSpidersWeb(Web web, Spider spider) {
        this.web = web;
        this.spider = spider;
    }

    public Spider spider() {
        return spider;
    }

    public Web web() {
        return web;
    }
}
