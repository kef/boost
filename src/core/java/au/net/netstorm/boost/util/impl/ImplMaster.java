package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface ImplMaster {
    Implementation defaultImpl(Interface type);

    boolean hasDefaultImpl(Interface iFace);
}
