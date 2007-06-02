package au.net.netstorm.boost.spider.flavour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.util.type.Interface;

final class DefaultFlavouredMapEngine implements FlavouredMapEngine {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private final Map map = new HashMap();
    private final Set ifaces = new HashSet();

    public void put(FlavouredInterface flavour, Object value) {
        Interface iface = flavour.getIface();
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        if (map.containsKey(unflavoured)) fail(flavour, "Unflavoured type already registered");
        if (map.containsKey(flavour)) fail(flavour, "Flavour already exists");
        ifaces.add(iface);
        map.put(flavour, value);
    }

    public Object get(FlavouredInterface flavour) {
        checkInterfaceExists(flavour);
        if (map.containsKey(flavour)) return map.get(flavour);
        if (!isFlavoured(flavour)) fail(flavour, "Unflavoured cannot be resolved when flavours exist");
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        if (map.containsKey(unflavoured)) return map.get(unflavoured);
        throw new FlavourMapException(flavour, "No matching flavour");
    }

    private void checkInterfaceExists(FlavouredInterface flavour) {
        Interface iface = flavour.getIface();
        if (!ifaces.contains(iface)) fail(flavour, "No matching type");
    }

    private void checkNoUnflavouredExists(FlavouredInterface flavour, Interface iface) {
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        if (map.containsKey(unflavoured)) fail(flavour, "Unflavoured type already registered");
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
