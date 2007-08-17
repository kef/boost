package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.spider.flavour.DefaultFlavour;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.flavour.FlavourMapException;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;
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
        try {
            Interface iface = getInterface(field);
            Flavour flavour = performTheMagicMove(field);
            return resolver.resolve(iface, flavour);
        } catch (FlavourMapException e) {
            throw new UnresolvedDependencyException(field, e);
        }
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }

    private Flavour performTheMagicMove(Field field) {
        String fieldName = field.getName();
        return new DefaultFlavour(fieldName);
    }
}