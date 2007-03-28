package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.pebble.resolve.Resolver;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFieldResolver implements FieldResolver {
    private final Resolver resolver;

    public DefaultFieldResolver(Resolver resolver) {
        this.resolver = resolver;
    }

    public ResolvedInstance resolve(Field field) {
        Interface iface = getInterface(field);
        return resolver.resolve(iface);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }
}