package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultProviderOperations implements ProviderOperations {
    public Class host(InjectionSite site, Provider provider) {
        Provider root = root(provider);
        if (!(root instanceof HasInjectableTarget)) return raw(site);
        HasInjectableTarget target = (HasInjectableTarget) root;
        return target.getTargetClass();
    }

    public Type[] params(Provider provider) {
        Provider root = root(provider);
        if (!(root instanceof HasParameters)) return new Type[0];
        HasParameters parameterized = (HasParameters) root;
        return parameterized.getParameterTypes();
    }

    public Provider root(Provider provider) {
        if (!(provider instanceof DelegatingProvider)) return provider;
        DelegatingProvider delegator = (DelegatingProvider) provider;
        Provider nested = delegator.root();
        return root(nested);
    }

    private Class raw(InjectionSite site) {
        InjectionType type = site.type();
        return type.rawClass();
    }
}
