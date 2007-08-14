package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.GreenPrintsMonkey;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

// SUGGEST: Onionise the put.
public final class DefaultResolverEngine implements ResolverEngine {
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    private final TypeMaster typer = new DefaultTypeMaster();
    private final ProviderEngine provider;
    private final GreenPrintsMonkey greenprints;
    private final Instances instances;
    private final NewerAssembler newer;

    public DefaultResolverEngine(
            ProviderEngine provider,
            GreenPrintsMonkey greenprints,
            Instances instances,
            NewerAssembler newer) {
        this.provider = provider;
        this.greenprints = greenprints;
        this.instances = instances;
        this.newer = newer;
    }

    public ResolvedInstance resolve(Interface iface, Flavour flavour) {
        if (isNewer(iface)) return nuNewer(iface);
        if (instances.exists(iface, flavour)) return instances.get(iface, flavour);
        return implementation(iface, flavour);
    }

    private ResolvedInstance implementation(Interface iface, Flavour flavour) {
        Blueprint blueprint = greenprints.get(iface, flavour);
        return resolve(iface, blueprint);
    }

    private ResolvedInstance resolve(Interface iface, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        ResolvedInstance result = provider.provide(impl);
        Flavour flavour = blueprint.getFlavour();
        if (isSingle(blueprint)) instances.put(iface, flavour, result);
        return result;
    }

    private boolean isSingle(Blueprint blueprint) {
        Stamp stamp = blueprint.getStamp();
        return stamp == Stamp.SINGLE;
    }

    private boolean isNewer(Interface iface) {
        return typer.extendz(iface, NEWER);
    }

    private ResolvedInstance nuNewer(Interface iface) {
        Newer ref = newer.assemble(iface);
        return new DefaultBaseReference(ref);
    }
}