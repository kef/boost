package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;

public interface ConfigurableFactory extends Factory {
    void configure(Web web);
}
