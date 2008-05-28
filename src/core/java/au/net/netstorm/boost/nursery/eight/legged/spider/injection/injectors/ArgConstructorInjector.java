package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

// FIX 2394 to be used by parameterized injection aka nuer
public final class ArgConstructorInjector implements ConstructorInjector {
    private final Provider provider;
    private final Object[] args;

    public ArgConstructorInjector(Provider provider, Object[] args) {
        this.provider = provider;
        this.args = args;
    }

    public Object inject() {
        return provider.nu(args);
    }
}
