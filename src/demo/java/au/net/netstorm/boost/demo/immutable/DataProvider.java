package au.net.netstorm.boost.demo.immutable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.gunge.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.immutable.DataInvocationHandler;
import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

// FIX 2130 Move into "core"?
public final class DataProvider implements Provider {
    private final Class iface;
    NuImpl impl;
    ProxySupplier proxies;

    public DataProvider(Class iface) {
        this.iface = iface;
    }

    public Object nu(Object... args) {
        Method[] methods = iface.getMethods();
        // FIX 9999 Tidy this.
        if (methods.length != args.length) throw new IllegalArgumentException("Parameters do not match data accessors");
        return create(methods, args);
    }

    private Object create(Method[] methods, Object[] args) {
        FieldValueSpec[] specs = specs(methods, args);
        InvocationHandler handler = handler(specs);
        return proxy(iface, handler);
    }

    private InvocationHandler handler(FieldValueSpec[] specs) {
        Interface tight = new DefaultInterface(iface);
        return new DataInvocationHandler(tight, specs);
    }

    private Object proxy(Class iface, InvocationHandler handler) {
        ClassLoader classloader = classloader();
        return proxies.getProxy(classloader, new Class[]{iface}, handler);
    }

    private ClassLoader classloader() {
        Class cls = getClass();
        return cls.getClassLoader();
    }

    private FieldValueSpec[] specs(Method[] methods, Object[] args) {
        List result = new ArrayList();
        for (int i = 0; i < methods.length; i++) {
            FieldValueSpec spec = spec(methods[i], args[i]);
            result.add(spec);
        }
        return (FieldValueSpec[]) result.toArray(new FieldValueSpec[]{});
    }

    private FieldValueSpec spec(Method method, Object value) {
        // FIX 9999 Consider "nu".
        String name = method.getName();
        return new DefaultFieldValueSpec(name, value);
    }

//
//    private Centipede proxy(FieldValueSpec name, FieldValueSpec legs) {
//        FieldValueSpec[] fields = new FieldValueSpec[]{name, legs};
//        return createProxy(Centipede.class, fields);
//    }
//
//    private Centipede createProxy(Class type, FieldValueSpec[] fields) {
//        InvocationHandler handler = createHandler(type, fields);
//        ClassLoader classLoader = getClass().getClassLoader();
//        Class[] proxyClasses = new Class[]{type};
//        return (Centipede) Proxy.newProxyInstance(classLoader, proxyClasses, handler);
//    }
//
//    private InvocationHandler createHandler(Class type, FieldValueSpec[] fields) {
//        Interface iFace = new DefaultInterface(type);
//        return new DataInvocationHandler(iFace, fields);
//    }
//
}
