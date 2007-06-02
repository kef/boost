package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFieldResolver implements FieldResolver {
    private final ResolverEngine resolver;

    public DefaultFieldResolver(ResolverEngine resolver) {
        this.resolver = resolver;
    }

    public ResolvedInstance resolve(Field field) {
        Interface iface = getInterface(field);
        Flavour flavour = getFlavour(field);
        return resolver.resolve(iface, flavour);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }

    private Flavour getFlavour(Field field) {
        // FIX 1977 We need a real flavour right?
        return Flavour.UNFLAVOURED;
    }
}