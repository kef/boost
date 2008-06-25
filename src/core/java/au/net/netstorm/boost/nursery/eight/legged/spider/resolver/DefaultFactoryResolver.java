package au.net.netstorm.boost.nursery.eight.legged.spider.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Binding;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;

public final class DefaultFactoryResolver implements FactoryResolver {
    private final Bindings bindings;
    private final Factories factories;

    public DefaultFactoryResolver(Bindings bindings, Factories factories) {
        this.bindings = bindings;
        this.factories = factories;
    }

    public Factory resolve(InjectionSite site) {
        InjectionType type = site.type();
        for (Binding binding : bindings.lookup(type)) {
            if (binding.accepts(site)) return binding.getFactory(site);
        }
        return factories.find(site);
    }
}
