package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFieldResolver implements FieldResolver {
    private final Resolver resolver;
    private final PebbleProvider provider;

    public DefaultFieldResolver(Resolver resolver, PebbleProvider provider) {
        this.provider = provider;
        this.resolver = resolver;
    }

    public Object resolve(Field field) {
        Interface iface = getInterface(field);
        return resolve(iface);
    }

    private Object resolve(Interface iface) {
        Implementation implementation = resolver.resolve(iface);
        return create(implementation);
    }

    private Object create(Implementation implementation) {
        Object[] parameters = {};
        Class impl = implementation.getImpl();
        return provider.provide(impl, parameters);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }
}