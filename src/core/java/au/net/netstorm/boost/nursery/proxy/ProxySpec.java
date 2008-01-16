package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.InvocationHandler;

public interface ProxySpec {
    Class<InvocationHandler>[] get();
}
