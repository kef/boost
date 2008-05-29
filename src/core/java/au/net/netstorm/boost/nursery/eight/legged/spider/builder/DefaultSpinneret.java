package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.DefaultWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.DefaultInjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap.DefaultBootstrapper;
import au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap.Bootstrapper;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.DefaultRules;

public final class DefaultSpinneret implements Spinneret {
    public SpidersWeb spin(WebConfig... configs) {
        Rules rules = new DefaultRules();
        InjectionWeb injections = new DefaultInjectionWeb(rules);
        Web web = new DefaultWeb(rules);
        SpidersWeb spider = bootstrap(web, injections);
        configure(web, configs);
        return spider;
    }

    private void configure(Web web, WebConfig[] configs) {
        for (WebConfig config : configs) config.apply(web);
    }

    private SpidersWeb bootstrap(Web web, InjectionWeb injections) {
        Bootstrapper bootstrapper = new DefaultBootstrapper(web, injections);
        bootstrapper.apply(web);
        return bootstrapper.getBootstrappedWeb();
    }
}
