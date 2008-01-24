package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.nursery.proxy.LayerWrapper;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.onion.core.Layer;

import java.util.ArrayList;
import java.util.List;

public final class DefaultClosures implements Closures {
    LayerWrapper wrapper;
    Nu nu;

    public <T, U extends Layer> T closure(T ref, Class<U> cls, Object... args) {
        Object[] all = combine(ref, args);
        Layer layer = nu.nu(cls, all);
        return wrapper.wrap(ref, layer);
    }

    private Object[] combine(Object ref, Object... args) {
        List result = new ArrayList();
        result.add(ref);
        for (Object arg : args) result.add(arg);
        return result.toArray(new Object[]{});
    }
}
