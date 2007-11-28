package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class NewerFactory implements Factory {
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    TypeMaster typer;
    NewerAssembler assembler;

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        return nuNewer(iface, provider);
    }

    public boolean canHandle(Interface iface) {
        return typer.extendz(iface, NEWER);
    }

    public boolean isSingle(Interface iface) {
        return true;
    }

    private ResolvedInstance nuNewer(Interface iface, ProviderEngine provider) {
        Newer newer = assembler.assemble(iface, provider);
        return new DefaultBaseReference(newer);
    }
}
