package au.net.netstorm.boost.nursery.eight.legged.spider.provider.multiplicity;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

// FIX 2394 what happens with providers underneath that can't produce multis
// FIX 2394 remove multi concept in favour of pass-through
public final class MultiProvider implements ProviderMultiplicity {
    private final Provider provider;

    public MultiProvider(Provider provider) {
        this.provider = provider;
    }

    public Object nu(Object... args) {
        return provider.nu(args);
    }
}
