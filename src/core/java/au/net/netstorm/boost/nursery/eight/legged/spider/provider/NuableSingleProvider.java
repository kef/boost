package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

public final class NuableSingleProvider implements Provider, DelegatingProvider {
    private final Provider multi;
    private final Provider single;

    public NuableSingleProvider(Provider delegate) {
        multi = delegate;
        single = new SingleProvider(delegate);
    }

    public Object nu(Object... args) {
        return args.length == 0 ? single.nu(args) : multi.nu(args);
    }

    public Provider root() {
        return multi;
    }
}
