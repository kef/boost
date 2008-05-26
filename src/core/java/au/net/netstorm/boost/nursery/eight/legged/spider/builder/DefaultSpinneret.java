package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.DefaultStatefulWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.StatefulWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.FactoryOrb;
import au.net.netstorm.boost.nursery.eight.legged.spider.orbs.BootstrapFactoryOrb;

public final class DefaultSpinneret implements Spinneret {
    public Web spin(FactoryOrb... factories) {
        StatefulWeb web = new DefaultStatefulWeb();
        bootstrap(web);
        web.register(factories);        
        return web;
    }

    private void bootstrap(Web web) {
        FactoryOrb factories = new BootstrapFactoryOrb();
        web.register(factories);
    }
}
