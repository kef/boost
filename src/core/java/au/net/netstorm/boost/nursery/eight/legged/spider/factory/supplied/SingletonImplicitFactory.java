package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.gunge.collection.Action;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.NuableSingleProvider;

// FIX 2394 Hackety Hack, McHack Hack.
// FIX 2394 use or lose. wire into BoostSpiderConfig when complete.
public final class SingletonImplicitFactory implements Factory {
    private IntegrityMap<InjectionType, Provider> kraftSingles = new DefaultIntegrityMap<InjectionType, Provider>();
    ImplicitFactory delegate;

    // FIX 2394 Spiking out an implicit single factory (equiv old spider).
    public Provider nu(final InjectionSite site) {
        InjectionType type = site.type();
        // FIX 2394 pull action out into its own class
        return kraftSingles.get(type, new Action<InjectionType, Provider>() {
            public Provider apply(InjectionType key) {
                Provider provider = delegate.nu(site);
                return new NuableSingleProvider(provider);
            }
        });
    }

    public boolean canHandle(InjectionSite site) {
        return delegate.canHandle(site);
    }
}
