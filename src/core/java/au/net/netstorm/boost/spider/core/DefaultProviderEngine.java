package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultProviderEngine implements ProviderEngine {
    private static final Interface INITIALISABLE = new DefaultInterface(Constructable.class);
    private final ResolvedThings resolvedThings = new DefaultResolvedThings();
    private final TypeMaster implMaster = new DefaultTypeMaster();
    private final Onionizer onionizer;
    private final Instantiator instantiator;
    private final InjectorEngine injector;

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
        if (implMaster.implementz(impl, INITIALISABLE)) init(resolved);
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
        Constructable constructable = (Constructable) resolved.getRef();
        constructable.constructor();
    }
}
