package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFieldResolver implements FieldResolver {
    private final Resolver resolver;
    private final PebbleProviderEngine provider;

    public DefaultFieldResolver(Resolver resolver, PebbleProviderEngine provider) {
        this.provider = provider;
        this.resolver = resolver;
    }

    public Object resolve(Field field, Object[] dependencies) {
        Interface iface = getInterface(field);
        return resolve(iface, dependencies);
    }

    // SUGGEST: This is probably the true resolver entry point and will likely take a "flavour".
    private Object resolve(Interface iface, Object[] dependencies) {
        Implementation implementation = resolver.resolve(iface);
        return create(implementation, dependencies);
    }

    private Object create(Implementation implementation, Object[] dependencies) {
        // FIX BREADCRUMB 1779 Take some params like a good little boy.
        return provider.provide(implementation, dependencies);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }
}