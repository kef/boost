package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import java.util.concurrent.atomic.AtomicReference;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.SingleProvider;

// FIX 2394 not quite right... want this to be able to handle many sites.
public final class SingletonFactory implements Factory {
    private final AtomicReference<Provider> ref = new AtomicReference<Provider>();
    private final Factory delgate;

    public SingletonFactory(Factory delegate) {
        this.delgate = delegate;
    }

    public Provider nu(InjectionSite site) {
        Provider provider = ref.get();
        if (provider != null) return provider;
        provider = delgate.nu(site);
        // FIX 2394 this is bogus
        Provider singleton = new SingleProvider(provider);
        ref.compareAndSet(null, singleton);
        return ref.get();
    }

    public boolean canHandle(InjectionSite site) {
        return delgate.canHandle(site);
    }
}
