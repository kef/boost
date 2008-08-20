package au.net.netstorm.boost.nursery.spider.onion.core;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.gunge.proxy.DefaultLayerFactory;
import au.net.netstorm.boost.gunge.proxy.LayerFactory;
import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.type.DefaultBaseReference;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.DefaultTypeMaster;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.gunge.type.TypeMaster;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.onion.core.Onionizer;

// FIX 1887 Use the Onion interface to mark the front door proxy.
// FIX 1887 Create a utility to determine whether an object reference is an onion or not.

// FIX 1887 Complete.

// FIX 1887 Remove this when done.

// DEBT ClassDataAbstractionCoupling {
public final class BermudaOnionizer implements Onionizer {
    private static final Interface DATA = new DefaultInterface(Data.class);
    private static final Interface ONION_SKIN = new DefaultInterface(OnionSkin.class);
    private final LayerFactory factory = new DefaultLayerFactory();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final ArrayMaster arrays = new DefaultArrayMaster();
    private final LordOfTheRings lord = new DefaultLordOfTheRings();

    // FIX 1887 Tidy.
    public ResolvedInstance onionise(Implementation impl, ResolvedInstance resolved) {
        // FIX BREADCRUMB 1887 CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC Return here.
        if (true) return resolved;
        Object ref = resolved.getRef();
        if (exemption(impl)) return resolved;
        if (!lord.ringed(impl)) return resolved;
        return onionise(impl, ref);
    }

    private ResolvedInstance onionise(Implementation impl, Object ref) {
        Interface[] facets = interfaces(impl);
        Layer layer = new OnionLayer(ref);
        Object proxy = factory.newProxy(facets, layer);
        return new DefaultBaseReference(proxy);
    }

    private Interface[] interfaces(Implementation impl) {
        Interface[] ifaces = typer.interfaces(impl);
        Interface[] onion = {ONION_SKIN};
        return arrays.plus(ifaces, onion);
    }

    private boolean exemption(Implementation impl) {
        return typer.implementz(impl, DATA);
    }
}
// } DEBT ClassDataAbstractionCoupling
