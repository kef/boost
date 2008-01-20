package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultLayerWrapper implements LayerWrapper {
    ProxyFactory proxies;
    TypeMaster master;
    Types types;

    public <T> T wrap(T ref, Layer layer) {
        Interface[] types = getTypes(ref);
        return (T) proxies.newProxy(types, layer);
    }

    private Interface[] getTypes(Object ref) {
        Class cls = ref.getClass();
        Implementation impl = types.nu(Implementation.class, cls);
        return master.interfaces(impl);
    }
}
