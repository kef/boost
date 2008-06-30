package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionContext;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultConstructorInjector implements ConstructorInjector {
    private final Provider provider;
    private final Injection[] injections;

    public DefaultConstructorInjector(Provider provider, Injection[] injections) {
        this.provider = provider;
        this.injections = injections;
    }

    public Object inject(InjectionContext context) {
        Object[] args = new Object[injections.length];
        for (int i = 0; i < injections.length; ++i) {
            args[i] = injections[i].apply(context);
        }
        return provider.nu(args);
    }
}
