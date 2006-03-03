package au.net.netstorm.boost.compose;

import au.net.netstorm.boost.util.type.Interface;

public interface Composer {
    Object compose(Interface iface, Class[] implementations);
}
