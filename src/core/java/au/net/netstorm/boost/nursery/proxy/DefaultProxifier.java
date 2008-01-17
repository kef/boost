package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

import java.lang.reflect.InvocationHandler;

public final class DefaultProxifier implements Proxifier {
    TypeMaster typeMaster;
    ProxyFactory proxies;
    Types types;
    Nu nu;

    public <T> T closure(T ref, ProxySpec spec) {
        Class<InvocationHandler>[] classes = spec.get();
        return (T) closure(ref, classes);
    }

    // FIX 2248 Looks dodgy.
    private Object closure(Object ref, Class<InvocationHandler>... classes) {
        Object closed = ref;
        for (int i = classes.length - 1; i >= 0; i--) {
            closed = proxy(closed, classes[i]);
        }
        return closed;
    }

    private Object proxy(Object ref, Class<InvocationHandler> cls) {
        Interface[] types = ifaces(ref);
        InvocationHandler closure = nu.nu(cls, ref);
        return proxies.newProxy(types, closure);
    }

    // FIX ()  2248 Dupe.  Slam into TypeMaster.
    private Interface[] ifaces(Object ref) {
        Class cls = ref.getClass();
        Implementation impl = types.nu(Implementation.class, cls);
        return typeMaster.declaredInterfaces(impl);
    }
}
