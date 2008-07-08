package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.DefaultProviderOperations;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.InstanceProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ProviderOperations;

public final class DefaultArgumentor implements Argumentor {
    private final ProviderOperations operations = new DefaultProviderOperations();

    public void providers(Providers providers, Provider provider, InjectionSite site, Object[] args) {
        if (args.length == 0) return;
        InjectionSite[] sites = sites(providers, site);
        providers(providers, sites, args);
    }

    private InjectionSite[] sites(Providers providers, InjectionSite site) {
        Provider provider = providers.get(site);
        return operations.constructors(site, provider);
    }

    private void providers(Providers providers, InjectionSite[] sites, Object[] args) {
        for (int i = 0; i < sites.length; i++) {
            register(providers, sites[i], args[i]);
        }
    }

    private void register(Providers providers, InjectionSite site, Object arg) {
        // FIX 2394 this is disgraceful, but arguments can legitemantly be null :(
        Object nullable = arg != null ? arg : Instances.NULL;
        Provider provider = new InstanceProvider(nullable);
        providers.put(site, provider);
    }
}
