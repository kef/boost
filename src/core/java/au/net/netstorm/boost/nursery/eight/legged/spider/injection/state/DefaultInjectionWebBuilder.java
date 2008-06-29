package au.net.netstorm.boost.nursery.eight.legged.spider.injection.state;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.DefaultFactoryResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;

public final class DefaultInjectionWebBuilder implements InjectionWebBuilder {
    public InjectionWeb build(Bindings bindings, Factories factories) {
        FactoryResolver resolver = new DefaultFactoryResolver(bindings, factories);
        return new DefaultInjectionWeb(resolver);
    }
}
