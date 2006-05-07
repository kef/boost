package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultComposer implements Composer {
    public DefaultComposer(ProxyFactory factory) {
    }

    public Object compose(Interface iface, Object delegateA, Object delegateB) {
        return null; // FIXME: SC521
    }
}
