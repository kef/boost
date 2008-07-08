package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.Web;

// FIX 2394 MAG Ugh. Ugly mo fo.
public final class DefaultSpinneret implements Spinneret {
    public SpiderEgg spin(Class<? extends SpiderConfig>... configs) {
        SpiderEgg egg = bootstrap();
        Web web = egg.spin();
        configure(web, configs);
        return egg;
    }

    private void configure(Web web, Class<? extends SpiderConfig>... configs) {
        for (Class<? extends SpiderConfig> config : configs) web.configure(config);
    }

    private SpiderEgg bootstrap() {
        Bootstrapper bootstrapper = new DefaultBootstrapper();
        bootstrapper.bootstrap();
        return bootstrapper.getBootstrappedWeb();
    }
}
