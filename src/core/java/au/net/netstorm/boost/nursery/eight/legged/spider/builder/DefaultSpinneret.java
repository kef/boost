package au.net.netstorm.boost.nursery.eight.legged.spider.builder;


import au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap.Bootstrapper;
import au.net.netstorm.boost.nursery.eight.legged.spider.bootstrap.DefaultBootstrapper;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.WebConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWebBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.DefaultInjectionWebBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.DefaultBindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.DefaultWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.SpidersWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.DefaultFactories;

public final class DefaultSpinneret implements Spinneret {
    private final InjectionWebBuilder injectionWebBuilder = new DefaultInjectionWebBuilder();

    public SpidersWeb spin(WebConfig... configs) {
        Bindings bindings = new DefaultBindings();
        Factories factories = new DefaultFactories();
        Web web = new DefaultWeb(bindings, factories);
        InjectionWeb injections = injectionWebBuilder.build(bindings, factories);
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
