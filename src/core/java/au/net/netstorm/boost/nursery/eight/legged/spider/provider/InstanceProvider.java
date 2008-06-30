package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class InstanceProvider extends Primordial implements Provider {
    private final Object instance;

    public InstanceProvider(Object instance) {
        this.instance = instance;
    }

    public Object nu(Object... args) {
        if (args.length != 0) throw new IllegalArgumentException("Instance provider does not support arguments.");
        return instance;
    }
}
