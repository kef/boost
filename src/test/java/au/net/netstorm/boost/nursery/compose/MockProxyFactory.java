package au.net.netstorm.boost.nursery.compose;

import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

final class MockProxyFactory extends Assert implements ProxyFactory {
    public Object newProxy(Interface type, Closure closure) {
        throw new NotImplementedException();
    }

    public Object newProxy(Interface[] types, Closure closure) {
        throw new NotImplementedException();
    }
}
