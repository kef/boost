package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.core.Holder;

public interface HolderUtility {
    <U, T extends Holder> T[] toHolderArray(Class<T> iface, U[] in);
}
