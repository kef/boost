package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.util.type.Interface;

public interface Composer {
    Object compose(Interface iface, Object delegateA, Object delegateB);
}
