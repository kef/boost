package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.spider.flavour.InterfaceMapException;
import au.net.netstorm.boost.spider.registry.CannotProvideException;
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
            Implementation host = getHost(field);
            return resolver.resolve(iface, host);
        } catch (InterfaceMapException e) {
            // FIX 2215 Should list ResolvedThings in this exception, not IME?
            throw new UnresolvedDependencyException(field, e);
        } catch (CannotProvideException e) {
            throw new UnresolvedDependencyException(field, e);
        }
    }

    private Implementation getHost(Field field) {
        Class hostClass = field.getDeclaringClass();
        return new DefaultImplementation(hostClass);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }
}