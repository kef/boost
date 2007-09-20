package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.spider.flavour.InterfaceMapException;
import au.net.netstorm.boost.spider.registry.DefaultImplementationRef;
import au.net.netstorm.boost.spider.registry.ImplementationRef;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
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
            ImplementationRef host = getHost(field);
            return resolver.resolve(iface, host);
        } catch (InterfaceMapException e) {
            throw new UnresolvedDependencyException(field, e);
        }
    }

    private ImplementationRef getHost(Field field) {
        Class hostClass = field.getDeclaringClass();
        Implementation hostImpl = new DefaultImplementation(hostClass);
        return new DefaultImplementationRef(hostImpl);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }
}