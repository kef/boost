package au.net.netstorm.boost.spider.flavour;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.Interface;

final class DefaultFlavouredMapEngine implements FlavouredMapEngine {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private Map map = new HashMap();

    public void put(FlavouredInterface flavour, Object value) {
        map.put(flavour, value);
    }

    public Object get(FlavouredInterface flavour) {
        Object value = map.get(flavour);
        if (value != null) return value;
        FlavouredInterface unflavoured = toUnflavoured(flavour);
        Object o = map.get(unflavoured);
        if (o == null) throw new FlavourMapException(flavour, "FOO");  // FIX 1977 Fix dodgy message.
        return o;
    }

    private FlavouredInterface toUnflavoured(FlavouredInterface flavour) {
        Interface iface = flavour.getIface();
        return new DefaultFlavouredInterface(iface, UNFLAVOURED);
    }
}
