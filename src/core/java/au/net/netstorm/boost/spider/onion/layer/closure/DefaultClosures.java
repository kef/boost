package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.nursery.proxy.Proxifier;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.array.ArrayMaster;

import java.util.ArrayList;
import java.util.List;

public final class DefaultClosures implements Closures {
    Proxifier proxifier;
    ArrayMaster arrays;
    Nu nu;

    public <T, U extends Layer> T closure(Class<U> cls, T ref, Object... args) {
        Object[] all = combine(ref, args);
        Layer layer = nu.nu(cls, all);
        return proxifier.proxy(ref, layer);
    }

    private Object[] combine(Object ref, Object... args) {
        List result = new ArrayList();
        result.add(ref);
        for (Object arg : args) result.add(arg);
        return arrays.toArray(result);
    }
}
