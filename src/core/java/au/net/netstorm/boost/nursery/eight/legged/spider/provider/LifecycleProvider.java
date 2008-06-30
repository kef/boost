package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.spider.core.Constructable;

// FIX 2394 this is not right, need to introduce the concept of post process actions, after resolve of fields
public final class LifecycleProvider implements Provider {
    private final Provider delegate;
    Marker marker;
    
    public LifecycleProvider(Provider delegate) {
        this.delegate = delegate;
    }

    public Object nu(Object... args) {
        Object instance = delegate.nu(args);
        if (marker.is(instance, Constructable.class)) construct(instance);
        return instance;
    }

    private void construct(Object instance) {
        Constructable constructable = (Constructable) instance;
        constructable.constructor();
    }
}
