package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultResolverEngine implements ResolverEngine {
    private static final Object[] NO_PARAMS = {};
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    private final TypeMaster typer = new DefaultTypeMaster();
    private final ProviderEngine provider;
    private final Blueprints blueprints;
    private final Instances instances;
    private final NewerAssembler newer;

    public DefaultResolverEngine(
            ProviderEngine provider,
            Blueprints blueprints,
            Instances instances,
            NewerAssembler newer) {
        this.provider = provider;
        this.blueprints = blueprints;
        this.instances = instances;
        this.newer = newer;
    }

    public ResolvedInstance resolve(Interface iface, Flavour flavour) {
        if (hasInstance(iface, flavour)) return getInstance(iface, flavour);
        return getImplementation(iface, flavour);
    }

    private ResolvedInstance getImplementation(Interface iface, Flavour flavour) {
        Blueprint blueprint = blueprints.getBlueprint(iface, flavour);
        Implementation impl = blueprint.getImplementation();
        return resolve(impl);
    }

    private ResolvedInstance resolve(Implementation impl) {
        // FIX BREADCRUMB 2081 GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG Remove NO_PARAMS.
        // FIX 1936 Modify provider to take no args.  Newer proxies use the arg'ed versions.
        return provider.provide(impl, NO_PARAMS);
    }

    // FIX 1977 Look closely at the Newer stuff.  Does it belong here or in a delegate?
    private ResolvedInstance getInstance(Interface iface, Flavour flavour) {
        // FIX 2081 Onionise on the put.
        // Suggest What about onionising the instance?
        if (isNewer(iface)) return nuNewer(iface);
        return instances.getInstance(iface, flavour);
    }

    private boolean hasInstance(Interface iface, Flavour flavour) {
        if (isNewer(iface)) return true;
        return instances.hasInstance(iface, flavour);
    }

    private boolean isNewer(Interface iface) {
        return typer.extendz(iface, NEWER);
    }

    private ResolvedInstance nuNewer(Interface iface) {
        Newer newer = this.newer.assemble(iface);
        return new DefaultBaseReference(newer);
    }
}