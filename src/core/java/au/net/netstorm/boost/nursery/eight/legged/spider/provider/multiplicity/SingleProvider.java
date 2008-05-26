package au.net.netstorm.boost.nursery.eight.legged.spider.provider.multiplicity;

import java.util.concurrent.atomic.AtomicReference;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

public final class SingleProvider implements ProviderMultiplicity {
    private final Provider provider;
    private final AtomicReference ref;

    public SingleProvider(Provider provider) {
        this.provider = provider;
        this.ref = new AtomicReference();
    }

    public Object nu(Object... args) {
        if (args.length != 0) throw new IllegalArgumentException("Single providers do not support arguments");
        return getOrCreate();
    }

    private Object getOrCreate() {
        Object instance = ref.get();
        if (instance != null) return instance;
        instance = provider.nu();
        ref.compareAndSet(null, instance);
        return ref.get();
    }
}
