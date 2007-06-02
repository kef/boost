package au.net.netstorm.boost.spider.flavour;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.Interface;

final class DefaultFlavouredMapEngine implements FlavouredMapEngine {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private Map map = new HashMap();

    public void put(FlavouredInterface flavoured, Object value) {
        map.put(flavoured, value);
    }

    public Object get(FlavouredInterface flavoured) {
        Object value = map.get(flavoured);
        if (value != null) return value;
        FlavouredInterface unflavoured = toUnflavoured(flavoured);
        return map.get(unflavoured);
    }

    private FlavouredInterface toUnflavoured(FlavouredInterface flavoured) {
        Interface iface = flavoured.getIface();
        return new DefaultFlavouredInterface(iface, UNFLAVOURED);
    }
}
