package au.net.netstorm.boost.spider.flavour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFlavouredMapEngine implements FlavouredMapEngine {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private final Map flavours = new HashMap();
    private final Set ifaces = new HashSet();

    public void put(FlavouredInterface flavour, Object value) {
        if (value == null) fail(flavour, "Come on, ya have to give me somethin' man.  Anything but a null");
        Interface iface = flavour.getIface();
        validate(flavour, iface);
        flavours.put(flavour, value);
        ifaces.add(iface);
    }

    // FIX 1977 Steve want two symmetric maps (flavoured, unflavoured).
    public Object get(FlavouredInterface flavour) {
        Object result = nullGet(flavour);
        if (result == null) explode(flavour);
        return result;
    }

    public boolean exists(FlavouredInterface flavour) {
        return nullGet(flavour) != null;
    }

    public Object nullGet(FlavouredInterface flavour) {
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        if (flavours.containsKey(unflavoured)) return flavours.get(unflavoured);
        if (flavours.containsKey(flavour)) return flavours.get(flavour);
        return null;
    }

    // OK CyclomaticComplexity {
    private void validate(FlavouredInterface flavour, Interface iface) {
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        if (flavours.containsKey(unflavoured)) fail(flavour, "Unflavoured type already registered");
        if (flavours.containsKey(flavour)) fail(flavour, "Flavour already exists");
        if (isFlavoured(flavour)) return;
        if (ifaces.contains(iface)) fail(flavour, "Flavour already exists");
    }
    // } OK CyclomaticComplexity - This was a tough cookie and is pretty damn clean.  Go for it if you can!

    private Object explode(FlavouredInterface flavour) {
        Interface iface = flavour.getIface();
        if (!ifaces.contains(iface)) fail(flavour, "No matching type");
        if (!isFlavoured(flavour)) fail(flavour, "Unflavoured cannot be resolved when flavours exist");
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
