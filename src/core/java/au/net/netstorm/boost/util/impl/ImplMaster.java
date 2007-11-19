package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface ImplMaster {
    <T, U extends T> Implementation<U> impl(Interface<T> type);

    boolean hasImpl(Interface<?> iFace);
}
