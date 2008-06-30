package au.net.netstorm.boost.nursery.eight.legged.spider.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.DefaultBindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.DefaultFactories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.DefaultInjectionWebBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWebBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;

public final class DefaultSpinneret implements Spinneret {
    private final InjectionWebBuilder injectionWebBuilder = new DefaultInjectionWebBuilder();

    public SpiderEgg spin(Class<? extends SpiderConfig>... configs) {
        Bindings bindings = new DefaultBindings();
        Factories factories = new DefaultFactories();
        InjectionWeb injections = injectionWebBuilder.build(bindings, factories);
        SpiderEgg egg = bootstrap(bindings, factories, injections);
        Web web = egg.spin();
        configure(web, configs);
        return egg;
    }

    private void configure(Web web, Class<? extends SpiderConfig>... configs) {
        for (Class<? extends SpiderConfig> config : configs) web.configure(config);
    }

    private SpiderEgg bootstrap(Bindings bindings, Factories factories, InjectionWeb injections) {
        Bootstrapper bootstrapper = new DefaultBootstrapper(bindings, factories, injections);
        bootstrapper.bootstrap();
        return bootstrapper.getBootstrappedWeb();
    }
}
