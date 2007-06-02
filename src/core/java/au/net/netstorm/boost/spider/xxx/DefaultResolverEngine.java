package au.net.netstorm.boost.spider.xxx;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.spider.resolve.FinderEngine;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngine implements ResolverEngine {
    private static final Object[] NO_PARAMS = {};
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    private final ProviderEngine provider;
    private final FinderEngine finder;
    private final NewerAssembler newerAssembler;

    public DefaultResolverEngine(ProviderEngine provider, FinderEngine finder, NewerAssembler newerAssembler) {
        this.provider = provider;
        this.finder = finder;
        this.newerAssembler = newerAssembler;
    }

    public ResolvedInstance resolve(Interface iface, Flavour flavour) {
        if (hasInstance(iface, flavour)) return getInstance(iface, flavour);
        return getImplementation(iface, flavour);
    }

    public ResolvedInstance resolve(Implementation impl, Flavour flavour) {
        // FIX 1936 Modify provider to take no args.  Newer proxies use the arg'ed versions.
        return provider.provide(impl, NO_PARAMS);
    }

    private ResolvedInstance getImplementation(Interface iface, Flavour flavour) {
        Implementation impl = finder.getImplementation(iface, flavour);
        return resolve(impl, flavour);
    }

    // FIX 1977 Look closely at the Newer stuff.  Does it belong here or in a delegate?
    private ResolvedInstance getInstance(Interface iface, Flavour flavour) {
        // Suggest What about onionising the instance?
        if (iface.is(NEWER)) return nuNewer(iface);
        return finder.getInstance(iface, flavour);
    }

    private boolean hasInstance(Interface iface, Flavour flavour) {
        if (iface.is(NEWER)) return true;
        return finder.hasInstance(iface, flavour);
    }

    private ResolvedInstance nuNewer(Interface iface) {
        Newer newer = newerAssembler.assemble(iface);
        return new DefaultBaseReference(newer);
    }
}