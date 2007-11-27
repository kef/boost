package au.net.netstorm.boost.nursery.type.holder;

import au.net.netstorm.boost.nursery.type.Holder;

public interface HolderUtility {
    <U, T extends Holder> T[] toHolderArray(Class<T> iface, U[] in);
}
