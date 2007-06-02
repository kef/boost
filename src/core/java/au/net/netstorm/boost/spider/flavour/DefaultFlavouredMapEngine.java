package au.net.netstorm.boost.spider.flavour;

import java.util.HashMap;
import java.util.Map;

final class DefaultFlavouredMapEngine implements FlavouredMapEngine {
    private Map map = new HashMap();

    public void put(FlavouredInterface flavoured, Object value) {
        map.put(flavoured, value);
    }

    public Object get(FlavouredInterface flavoured) {
        return map.get(flavoured);
    }
}
