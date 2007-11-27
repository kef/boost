package au.net.netstorm.boost.nursery.type.holder;

import java.lang.reflect.Array;
import au.net.netstorm.boost.nursery.type.Holder;
import au.net.netstorm.boost.nursery.type.Types;

public final class DefaultHolderUtility implements HolderUtility {
    Types types;

    public <U, T extends Holder> T[] toHolderArray(Class<T> iface, U[] in) {
        T[] result = (T[]) Array.newInstance(iface, in.length);
        for (int i = 0; i < in.length; i++) {
            result[i] = types.nu(iface, in[i]);
        }
        return result;
    }
}
