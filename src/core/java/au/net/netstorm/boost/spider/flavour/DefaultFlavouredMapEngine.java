package au.net.netstorm.boost.spider.flavour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1977 RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR Remove checkstylers...

// DEBT NCSS|CyclomaticComplexity {
final class DefaultFlavouredMapEngine implements FlavouredMapEngine {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private final Map flavours = new HashMap();
    private final Set ifaces = new HashSet();

    public void put(FlavouredInterface flavour, Object value) {
        Interface iface = flavour.getIface();
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        if (flavours.containsKey(unflavoured)) fail(flavour, "Unflavoured type already registered");
        if (flavours.containsKey(flavour)) fail(flavour, "Flavour already exists");
        boolean flavoured = isFlavoured(flavour);
        if (!flavoured && ifaces.contains(iface)) fail(flavour, "Flavour already exists");
        flavours.put(flavour, value);
        ifaces.add(iface);
    }

    public Object get(FlavouredInterface flavour) {
        Interface iface = flavour.getIface();
        if (!ifaces.contains(iface)) fail(flavour, "No matching type");
        if (flavours.containsKey(flavour)) return flavours.get(flavour);
        if (!isFlavoured(flavour)) fail(flavour, "Unflavoured cannot be resolved when flavours exist");
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        if (flavours.containsKey(unflavoured)) return flavours.get(unflavoured);
        throw new FlavourMapException(flavour, "No matching flavour");
    }

    private FlavouredInterface toUnflavoured(FlavouredInterface flavour) {
        Interface iface = flavour.getIface();
        return new DefaultFlavouredInterface(iface, UNFLAVOURED);
    }

    private boolean isFlavoured(FlavouredInterface flavour) {
        Flavour actual = flavour.getFlavour();
        return !actual.equals(UNFLAVOURED);
    }

    private void fail(FlavouredInterface flavour, String msg) {
        throw new FlavourMapException(flavour, msg);
    }
}
// } DEBT NCSS|CyclomaticComplexity
