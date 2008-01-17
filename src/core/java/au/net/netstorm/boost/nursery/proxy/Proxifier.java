package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.InvocationHandler;

public interface Proxifier {
    // FIX 2248 Rename?
    <T> T closure(T ref, ProxySpec spec);

    <T> T closure(T ref, Class<? extends InvocationHandler>... closures);
}
