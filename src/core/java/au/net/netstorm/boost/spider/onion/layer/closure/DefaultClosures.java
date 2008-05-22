package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.nursery.proxy.Proxifier;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.onion.core.Layer;

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
        Object[] result = new Object[args.length + 1];
        result[0] = ref;
        System.arraycopy(args, 0, result, 1, args.length);
        return result;
    }
}
