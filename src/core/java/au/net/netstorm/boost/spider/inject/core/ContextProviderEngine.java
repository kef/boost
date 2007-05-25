package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 54976 Remove.
public class ContextProviderEngine implements ProviderEngine {
    private final ResolvedThings resolvedThings;
    private final ProviderEngine delegate;

    public ContextProviderEngine(ProviderEngine delegate, ResolvedThings resolvedThings) {
        this.resolvedThings = resolvedThings;
        this.delegate = delegate;
    }

    public ResolvedInstance provide(Implementation implementation, Object[] resolved) {
        try {
            resolvedThings.clear();
            return delegate.provide(implementation, resolved);
        } finally {
            resolvedThings.clear();
        }
    }
}
