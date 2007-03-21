package au.net.netstorm.boost.demo.pebble.core;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;

// FIX 1779 Add getResolver.

// FIX BREADCRUMB 1779 Fix StringMaster.toString to flatten objects with a single field.
public interface PebblePortal {
    PebbleProvider getProvider();

    Injector getInjector();
}
