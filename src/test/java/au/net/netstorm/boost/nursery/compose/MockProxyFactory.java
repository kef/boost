package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.gunge.exception.NotImplementedException;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.onion.core.Layer;
import junit.framework.Assert;

final class MockProxyFactory extends Assert implements ProxyFactory {
    public Object newProxy(Interface type, Layer layer) {
        throw new NotImplementedException();
    }

    public Object newProxy(Interface[] types, Layer layer) {
        throw new NotImplementedException();
    }
}
