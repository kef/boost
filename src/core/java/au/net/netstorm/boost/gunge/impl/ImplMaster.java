package au.net.netstorm.boost.gunge.impl;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

public interface ImplMaster {
    <T, U extends T> Class<U> impl(Class<T> iface);

    <T, U extends T> Implementation<U> impl(Interface<T> iface);

    boolean hasImpl(Interface<?> iFace);
}
