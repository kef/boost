package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.DefaultStatefulWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.StatefulWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap.BootstrapWebConfig;

public final class DefaultSpinneret implements Spinneret {
    public Web spin(WebConfig... configs) {
        StatefulWeb web = new DefaultStatefulWeb();
        bootstrap(web);
        configure(web, configs);
        return web;
    }

    private void configure(Web web, WebConfig[] configs) {
        for (WebConfig config : configs) config.apply(web);
    }

    private void bootstrap(Web web) {
        WebConfig bootstrapper = new BootstrapWebConfig();
        bootstrapper.apply(web);
    }
}
