package au.net.netstorm.boost.nursery.eight.legged.spider.provider.core;

import java.util.concurrent.atomic.AtomicReference;

import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.gunge.type.Implementation;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public final class SingleProvider implements Provider {
    private final AtomicReference<UnresolvedInstance> single = new AtomicReference<UnresolvedInstance>();
    private final Provider multi;

    public SingleProvider(Implementation impl) {
        multi = new MultiProvider(impl);
    }
    public UnresolvedInstance nu(ResolvedInstance... args) {
        // FIX 2328 this should be abstracted into a getOrCreate(AtomicReference, Creator);
        UnresolvedInstance instance = single.get();
        if (instance != null) return instance;
        instance = multi.nu(args);
        single.compareAndSet(null, instance);
        return single.get();
    }
}
