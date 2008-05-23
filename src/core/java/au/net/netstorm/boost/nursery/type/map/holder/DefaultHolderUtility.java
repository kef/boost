package au.net.netstorm.boost.nursery.type.map.holder;

import java.lang.reflect.Array;
import au.net.netstorm.boost.nursery.type.core.Holder;
import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultHolderUtility implements HolderUtility {
    Nu nu;

    public <U, T extends Holder> T[] toHolderArray(Class<T> iface, U[] in) {
        T[] result = (T[]) Array.newInstance(iface, in.length);
        for (int i = 0; i < in.length; i++) {
            result[i] = nu.nu(iface, in[i]);
        }
        return result;
    }
}
