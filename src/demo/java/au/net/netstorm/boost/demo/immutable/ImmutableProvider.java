package au.net.netstorm.boost.demo.immutable;

import java.lang.reflect.Method;
import au.net.netstorm.boost.gunge.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.immutable.DataLayer;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2130 Move into "core"?
public final class ImmutableProvider implements Provider {
    private final Interface iface;
    NuImpl impl;
    ProxyFactory proxies;

    public ImmutableProvider(Interface iface) {
        this.iface = iface;
    }

    public Object nu(Object... args) {
        Method[] methods = methods(iface);
        // FIX 2130 Tidy this.
        if (methods.length != args.length) throw new IllegalArgumentException("Parameters do not match data accessors");
        return create(methods, args);
    }

    private Method[] methods(Interface iface) {
        Class type = iface.getType();
        return type.getMethods();
    }

    private Object create(Method[] methods, Object[] args) {
        FieldValueSpec[] specs = specs(methods, args);
        Layer layer = new DataLayer(iface, specs);
        return proxies.newProxy(iface, layer);
    }

    private FieldValueSpec[] specs(Method[] methods, Object[] args) {
        FieldValueSpec[] result = new FieldValueSpec[methods.length];
        for (int i = 0; i < methods.length; i++) {
            result[i] = spec(methods[i], args[i]);
        }
        return result;
    }

    private FieldValueSpec spec(Method method, Object value) {
        // FIX 2130 Consider "nu".
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
