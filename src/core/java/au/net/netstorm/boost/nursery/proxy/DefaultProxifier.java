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
    ProxySpec spec;
    Types types;
    Nu nu;

    // FIX 2248 Push ProxySpec out.
    public <T> T closure(T ref) {
        Class<InvocationHandler>[] classes = spec.get();
        return (T) closure(ref, classes);
    }

    // FIX 2248 Looks dodgy.
    private Object closure(Object ref, Class<InvocationHandler>... classes) {
        Object closed = ref;
        for (Class cls : classes) {
            closed = proxy(closed, cls);
        }
        return closed;
    }

    private Object proxy(Object ref, Class<InvocationHandler> cls) {
        Interface[] types = ifaces(ref);
        InvocationHandler closure = nu.nu(cls, ref);
        return proxies.newProxy(types, closure);
    }

    private Interface[] ifaces(Object ref) {
        Class cls = ref.getClass();
        Implementation impl = types.nu(Implementation.class, cls);
        return typeMaster.declaredInterfaces(impl);
    }
}
