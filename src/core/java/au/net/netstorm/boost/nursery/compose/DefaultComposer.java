package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.proxy.LayerProxyFactory;
import au.net.netstorm.boost.gunge.type.Interface;

public final class DefaultComposer implements Composer {
    public DefaultComposer(LayerProxyFactory factory) {
    }

    public Object compose(Interface iface, Object delegateA, Object delegateB) {
        return null; // SUGGEST
    }
}
