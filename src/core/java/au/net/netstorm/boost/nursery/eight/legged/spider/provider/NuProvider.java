package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

// FIX 2394 not sure this is the best way to do it, could register instances for a site rather than provider
public final class NuProvider implements Provider, DelegatingProvider {
    private final Provider delegate;
    private final Object[] args;

    public NuProvider(Provider delegate, Object... args) {
        this.delegate = delegate;
        this.args = args;
    }

    public Object nu(Object... none) {
        if (none.length != 0) throw new IllegalArgumentException();
        return delegate.nu(args);
    }

    public Provider root() {
        return delegate;
    }
}
