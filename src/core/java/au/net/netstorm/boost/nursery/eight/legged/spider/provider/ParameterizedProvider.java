package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class ParameterizedProvider extends Primordial implements Provider, DelegatingProvider {
    private final Provider provider;
    private final Object[] args;
    private Object[] nastyTempToStringHack;

    public ParameterizedProvider(Provider provider, Object[] args) {
        this.provider = provider;
        this.args = args;
    }

    // FIX 2394 Needs some typing goodness here to allow for two provider styles with out the check everywhere.
    public Object nu(Object... overridden) {
        nastyTempToStringHack = overridden;
        if (overridden.length != 0) throw new IllegalStateException("Provider does not support delayed args: " + this);
        return provider.nu(args);
    }

    public Provider root() {
        return provider;
    }
}
