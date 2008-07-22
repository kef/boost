package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import au.net.netstorm.boost.bullet.primordial.Primordial;

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