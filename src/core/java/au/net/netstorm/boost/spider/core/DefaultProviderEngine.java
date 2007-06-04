package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultProviderEngine implements ProviderEngine {
    private static final Interface INITIALISABLE = new DefaultInterface(Initialisable.class);
    private final ResolvedThings resolvedThings = new DefaultResolvedThings();
    private Onionizer onionizer;
    private Instantiator instantiator;
    private InjectorEngine injector;

    // OK LineLength {
    public DefaultProviderEngine(Onionizer onionizer, InjectorEngine injector, Instantiator instantiator) {
        this.onionizer = onionizer;
        this.injector = injector;
        this.instantiator = instantiator;
    }
    // } OK LineLength 

    // SUGGEST: Strongly type Object[] as Dependencies?
    // FIX 1977 Object[] should be ConstructorParameter[].

    public ResolvedInstance provide(Implementation impl, Object[] parameters) {
        // FIX 1971 Test drive this check up.
        if (resolvedThings.exists(impl)) return resolvedThings.get(impl);
        ResolvedInstance resolved = getResolvedInstance(impl, parameters);
        if (impl.is(INITIALISABLE)) init(resolved);
        return onionizer.onionise(resolved);
    }

    private ResolvedInstance getResolvedInstance(Implementation impl, Object[] parameters) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, parameters);
        // FIX 1971 Test drive this check up.
        // FIX 1977 Put in a proxy.
        // FIX 1977 Consider removing try/finally block around spider.
        resolvedThings.put(impl, unresolved);
        injector.inject(unresolved);
        resolvedThings.remove(impl);
        return (ResolvedInstance) unresolved;
    }

    private void init(ResolvedInstance resolved) {
        Initialisable initialisable = (Initialisable) resolved.getRef();
        initialisable.initialise();
    }

    // FIX 1757 Remove when done.
    // FIX BREADCRUMB 1757 !!!!!!!! We probably want to onionise the Gaijins.
    // FIX 1757 Pebble provider should remain pure.  Front-end.
    // FIX 1757 We need a gaijin provider for Set/HashSet.
    // FIX 1757 When you see the HashSet must have a single constructor ... remember Pebble as a marker interface.

/*
    if (gaijin(type)) {
        return gaijiniator.instantiate(type, parameters);
    } else {
        Object ref = instantiator.instantiate(type, parameters);
        injector.inject(ref); // FIX 1757 Pass in type (later).
        return onion.onionise(ref);
    }
*/
}
