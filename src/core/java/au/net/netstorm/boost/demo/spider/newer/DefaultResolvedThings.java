package au.net.netstorm.boost.demo.spider.newer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultResolvedThings implements ResolvedThings {
    private static final ThreadLocal LOCAL_MON = new ThreadLocal();

    public void clear() {
        Map map = get();
        map.clear();
    }

    public boolean exists(Interface iface) {
        Map map = get();
        return map.containsKey(iface);
    }

    public ResolvedInstance get(Interface iface) {
        if (!exists(iface)) throw new IllegalStateException("Naff off you trollop.");
        Map map = get();
        return (ResolvedInstance) map.get(iface);
    }

    public void put(Interface iface, UnresolvedInstance ref) {
        Map map = get();
        map.put(iface, ref);
    }

    public String toString() {
        Map map = get();
        Set keys = map.keySet();
        return "" + keys;
    }

    public void remove(Interface iface) {
        Map map = get();
        map.remove(iface);
    }

    private Map get() {
        Map map = (Map) LOCAL_MON.get();
        if (map != null) return map;
        return nuMap();
    }

    private Map nuMap() {
        Map map = new LinkedHashMap();
        LOCAL_MON.set(map);
        return get();
    }
}
