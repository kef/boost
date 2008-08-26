package au.net.netstorm.boost.nursery.eight.legged.spider.ioc;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter.Aspector;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.ImplicitFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.Mappings;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied.PrefixMapping;
import au.net.netstorm.boost.nursery.eight.legged.spider.legacy.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class BoostSpiderConfig implements SpiderConfig {
    Binder binder;
    Web web;
    Resolver resolver;
    Aspector aspector;

    public void configure() {
        bindImplicits();
        bindLegacy();
    }

    private void bindImplicits() {
        // FIX 2394 use case for a wrapper to allow setting of multiplicity only.
        binder.bind(ImplicitFactory.class).toSingle(ImplicitFactory.class);
        web.register(ImplicitFactory.class);
        // FIX 2394 consistency with old spider, once SingletonImplicitFactory is complete.
//        web.register(SingletonImplicitFactory.class);
        Mappings mappings = resolver.resolve(Mappings.class);
        Mapping mapper = new PrefixMapping("Default");
        mappings.add(mapper);
    }

    private void bindLegacy() {
        Registry registry = new DefaultRegistry(binder, aspector);
        binder.bind(Registry.class).to(registry);
    }
}
