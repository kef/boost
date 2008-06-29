package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;

public interface Bootstrapper extends WebConfig, RuleConfig {
    SpidersWeb getBootstrappedWeb();
}
