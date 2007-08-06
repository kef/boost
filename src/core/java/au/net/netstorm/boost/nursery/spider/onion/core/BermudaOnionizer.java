package au.net.netstorm.boost.nursery.spider.onion.core;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.spider.inject.newer.assembly.DefaultProxyFactoryAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.ProxyFactoryAssembler;
import au.net.netstorm.boost.spider.onion.core.Onionizer;
import au.net.netstorm.boost.util.array.ArrayMaster;
import au.net.netstorm.boost.util.array.DefaultArrayMaster;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX 1887 Use the Onion interface to mark the front door proxy.
// FIX 1887 Create a utility to determine whether an object reference is an onion or not.

// SUGGEST: Do some proxy magic in here ;)

// FIX 1887 Complete.
public final class BermudaOnionizer implements Onionizer {
    private static final Interface DATA = new DefaultInterface(Data.class);
    private static final Interface ONION_SKIN = new DefaultInterface(OnionSkin.class);
    private final ProxyFactoryAssembler assembler = new DefaultProxyFactoryAssembler();
    private final ProxyFactory factory = assembler.assemble();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final ArrayMaster arrays = new DefaultArrayMaster();

    // FIX 1887 Tidy.
    public ResolvedInstance onionise(Implementation impl, ResolvedInstance resolved) {
        Object ref = resolved.getRef();
        if (exemption(impl)) return resolved;
        return onionise(impl, ref);
    }

    private ResolvedInstance onionise(Implementation impl, Object ref) {
        Interface[] facets = interfaces(impl);
        InvocationHandler handler = new OnionHandler(ref);
        Object proxy = factory.newProxy(facets, handler);
        return new DefaultBaseReference(proxy);
    }

    private Interface[] interfaces(Implementation impl) {
        Interface[] ifaces = typer.interfaces(impl);
        Interface[] onion = {ONION_SKIN};
        return (Interface[]) arrays.plus(ifaces, onion);
    }

    private boolean exemption(Implementation impl) {
        return typer.implementz(impl, DATA);
    }
}
