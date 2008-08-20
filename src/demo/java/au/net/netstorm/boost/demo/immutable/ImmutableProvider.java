package au.net.netstorm.boost.demo.immutable;

import java.lang.reflect.Method;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.proxy.LayerFactory;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.immutable.DataLayer;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2130 --- (Coordinate with MH) Move into "core"?

// FIX 2130 Consider making nu part of a Pebble superclass.
public final class ImmutableProvider implements Provider {
    private final Interface iface;
    LayerFactory proxies;
    NuImpl impl;
    Nu nu;

    public ImmutableProvider(Interface iface) {
        this.iface = iface;
    }

    public Object nu(Object... args) {
        Method[] methods = methods(iface);
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
        String name = method.getName();
        return nu.nu(FieldValueSpec.class, name, value);
    }
}
