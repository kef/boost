package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;

public interface Bootstrapper {
    SpidersWeb getBootstrappedWeb();
    void bootstrap();
}
