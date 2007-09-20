package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class NewerFactory implements Factory {
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    private final TypeMaster typer = new DefaultTypeMaster();
    private final NewerAssembler newer;

    public NewerFactory(NewerAssembler newer) {
        this.newer = newer;
    }

    public ResolvedInstance get(Interface iface, ImplementationRef host, ProviderEngine provider, Instances instances) {
        ResolvedInstance newerInstance = nuNewer(iface);
        instances.put(iface, newerInstance);
        return newerInstance;
    }

    public boolean canHandle(Interface iface) {
        return typer.extendz(iface, NEWER);
    }

    private ResolvedInstance nuNewer(Interface iface) {
        Newer ref = newer.assemble(iface);
        return new DefaultBaseReference(ref);
    }
}
