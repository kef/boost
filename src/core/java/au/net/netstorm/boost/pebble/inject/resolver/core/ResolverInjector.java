package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

public final class ResolverInjector implements Injector {
    public void inject(Object object) {
        // FIX 1715 Do this.
        // 1. For each candidate field.
        // 2. Determine field interface.
        // 3. Call resolver to get implementation type.
        // 4. Instantiate implementation.
        // 5. Set field.
    }
}
