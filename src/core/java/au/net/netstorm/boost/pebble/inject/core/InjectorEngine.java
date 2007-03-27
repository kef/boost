package au.net.netstorm.boost.pebble.inject.core;

import au.net.netstorm.boost.util.type.UnresolvedInstance;

// FIX 32755 Belongs somewhere else.
public interface InjectorEngine {
    void inject(UnresolvedInstance unresolved);
}
