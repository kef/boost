package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface ImplMaster {
    <T, U extends T> Class<U> impl(Class<T> iface);

    <T, U extends T> Implementation<U> impl(Interface<T> iface);

    boolean hasImpl(Interface<?> iFace);
}
