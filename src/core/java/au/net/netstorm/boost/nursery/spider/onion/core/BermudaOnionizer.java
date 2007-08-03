package au.net.netstorm.boost.nursery.spider.onion.core;

import au.net.netstorm.boost.spider.inject.newer.assembly.DefaultProxyFactoryAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.ProxyFactoryAssembler;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX 1887 Use the Onion interface to mark the front door proxy.
// FIX 1887 Create a utility to determine whether an object reference is an onion or not.

// SUGGEST: Do some proxy magic in here ;)

// FIX 1887 Complete.
public final class BermudaOnionizer implements Onionizer {
    private final ProxyFactoryAssembler assembler = new DefaultProxyFactoryAssembler();
    private final ProxyFactory factory = assembler.assemble();
    private final TypeMaster typer = new DefaultTypeMaster();

    public ResolvedInstance onionise(Implementation impl, ResolvedInstance resolved) {
        return resolved;
//        Object ref = resolved.getRef();
//        Interface[] ifaces = typer.interfaces(impl);
//        InvocationHandler handler = null;
//        Object proxy = factory.newProxy(ifaces, handler);
//        // FIX BREADCRUMB 1887 AAAAAAAAAAAAAAAAAAAA Return the proxy here.
    }
}
