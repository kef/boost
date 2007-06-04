package au.net.netstorm.boost.demo.spider.newer;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultResolvedThings implements ResolvedThings {
    private static final ThreadLocal LOCAL_MON = new ThreadLocal();

    public void clear() {
        Map map = get();
        map.clear();
    }

    public boolean exists(Implementation impl) {
        Map map = get();
        return map.containsKey(impl);
    }

    public ResolvedInstance get(Implementation impl) {
        if (!exists(impl)) throw new IllegalStateException("Naff off you trollop.");
        Map map = get();
        return (ResolvedInstance) map.get(impl);
    }

    public void put(Implementation impl, UnresolvedInstance ref) {
        Map map = get();
        map.put(impl, ref);
    }

    public void remove(Implementation impl) {
        Map map = get();
        map.remove(impl);
    }

    private Map get() {
        Map map = (Map) LOCAL_MON.get();
        if (map != null) return map;
        Map map1 = new HashMap();
        LOCAL_MON.set(map1);
        return get();
    }
}
