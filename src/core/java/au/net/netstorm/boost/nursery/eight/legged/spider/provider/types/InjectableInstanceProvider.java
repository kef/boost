package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

import au.net.netstorm.boost.bullet.primordial.Primordial;

// FIX 2394 this highlights a major problem, that InjectableTarget can not be determined by provider type
public final class InjectableInstanceProvider extends Primordial implements Provider, HasInjectableTarget {
    private final Object instance;

    public InjectableInstanceProvider(Object instance) {
        this.instance = instance;
    }

    public Class<?> getTargetClass() {
        return instance.getClass();
    }

    public Object nu(Object... args) {
        if (args.length != 0) throw new IllegalArgumentException("Instance provider does not support arguments.");
        return instance;
    }
}