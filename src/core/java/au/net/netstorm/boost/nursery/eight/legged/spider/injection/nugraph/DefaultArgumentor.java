package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;

public final class DefaultArgumentor implements Argumentor {
    private final ProviderOperations operations = new DefaultProviderOperations();
    private final InjectionSiteBuilder builder = new DefaultInjectionSiteBuilder();

    public void register(Providers providers, Instances instances, InjectionSite site, Object[] args) {
        if (args.length == 0) return;
        InjectionSite[] sites = sites(providers, site, args);
        register(instances, sites, args);
    }

    private void register(Instances instances, InjectionSite[] sites, Object[] args) {
        for (int i = 0; i < sites.length; i++) {
            instances.put(sites[i], args[i]);
        }
    }

    private InjectionSite[] sites(Providers providers, InjectionSite site, Object[] args) {
        Provider provider = providers.get(site);
        Class host = operations.host(site, provider);
        Type[] types = operations.params(provider);
        if (types.length != args.length) throw new IllegalArgumentException();
        return builder.constructors(host, types);
    }
}
