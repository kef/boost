package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

public final class InstanceProvider implements Provider {
    private final Object instance;

    public InstanceProvider(Object instance) {
        this.instance = instance;
    }

    public Object nu(Object... args) {
        if (args.length != 0) throw new IllegalArgumentException("Instance provider does not support arguments.");
        return instance;
    }
}
