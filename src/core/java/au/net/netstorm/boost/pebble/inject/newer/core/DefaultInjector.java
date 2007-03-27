package au.net.netstorm.boost.pebble.inject.newer.core;

import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

// FIX 32755 Move out of here.
public final class DefaultInjector implements Injector {
    private final InjectorEngine engine;

    public DefaultInjector(InjectorEngine engine) {
        this.engine = engine;
    }

    public void inject(Object ref) {
        UnresolvedInstance unresolved = new DefaultBaseReference(ref);
        engine.inject(unresolved);
    }
}
