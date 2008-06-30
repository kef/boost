package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;

public interface Bootstrapper extends RuleConfig {
    SpidersWeb getBootstrappedWeb();

    void bootstrap();
}
