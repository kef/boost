package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class CitizenInjectorEngine implements InjectorEngine {
    private final InjectorEngine resolverInjector;

    public CitizenInjectorEngine(InjectorEngine resolverInjector) {
        this.resolverInjector = resolverInjector;
    }

    public void inject(UnresolvedInstance unresolved) {
        resolverInjector.inject(unresolved);
    }
}
