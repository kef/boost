package au.net.netstorm.boost.pebble.resolve;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.ImplementationLookup;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultResolver implements Resolver {
    private final PebbleProviderEngine provider;
    private final Resolver resolver;
    private final ImplementationLookup lookup;
    private final ReflectMaster reflector = new DefaultReflectMaster();

    public DefaultResolver(PebbleProviderEngine provider, Resolver resolver, ImplementationLookup lookup) {
        this.provider = provider;
        this.resolver = resolver;
        this.lookup = lookup;
    }

    public Object resolve(Interface iface) {
        Implementation impl = lookup.find(iface);
        return resolve(impl);
    }

    public Object resolve(Implementation impl) {
        Class[] parameters = getParameters(impl);
        Object[] resolved = resolve(parameters);
        return provider.provide(impl, resolved);
    }

    private Object[] resolve(Class[] parameters) {
        return new Object[]{};
    }

    private Class[] getParameters(Implementation iface) {
        Class cls = iface.getClass();
        Constructor constructor = reflector.getConstructor(cls);
        return constructor.getParameterTypes();
    }
}
