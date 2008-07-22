package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultProviderOperations implements ProviderOperations {
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();

    public InjectionSite[] constructors(InjectionSite site, Provider provider) {
        Type[] types = params(provider);
        Class raw = host(site, provider);
        return builder.constructors(raw, types);
    }

    public Class host(InjectionSite site, Provider provider) {
        InjectionType type = site.type();
        Class raw = type.rawClass();
        return host(raw, provider);
    }

    private Class host(Class raw, Provider provider) {
        Provider root = root(provider);
        if (!(root instanceof HasInjectableTarget)) return raw;
        HasInjectableTarget target = (HasInjectableTarget) root;
        return target.getTargetClass();
    }

    public Type[] params(Provider provider) {
        Provider root = root(provider);
        if (!needsParameters(provider, root)) return new Type[0];
        HasParameters parameterized = (HasParameters) root;
        return parameterized.getParameterTypes();
    }

    private boolean needsParameters(Provider outer, Provider root) {
        return root instanceof HasParameters && !(outer instanceof ParameterizedProvider);
    }

    public Provider root(Provider provider) {
        if (!(provider instanceof DelegatingProvider)) return provider;
        DelegatingProvider delegator = (DelegatingProvider) provider;
        Provider nested = delegator.root();
        return root(nested);
    }
}
