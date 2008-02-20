package au.net.netstorm.boost.nursery.spider.inject.resolver.core;

import au.net.netstorm.boost.spider.flavour.MapException;
import au.net.netstorm.boost.spider.inject.resolver.core.FieldResolver;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.registry.CannotProvideException;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.util.type.ResolvedInstance;

import java.lang.reflect.Field;

// FIX ()   2237 NURSERY --- Move out of here.  Test still exists.
public final class DefaultFieldResolver implements FieldResolver {
    private final LinkageFactory linkages = new DefaultLinkageFactory();
    private final ResolverEngine resolver;

    public DefaultFieldResolver(ResolverEngine resolver) {
        this.resolver = resolver;
    }

    public ResolvedInstance resolve(Field field) {
        try {
            Linkage linkage = linkages.nu(field);
            return resolver.resolve(linkage);
        } catch (MapException e) {
            // FIX 2215 Should list ResolvedThings/InProgress/PartialInstances in this exception, not IME?
            throw new UnresolvedDependencyException(field, e);
        } catch (CannotProvideException e) {
            throw new UnresolvedDependencyException(field, e);
        }
    }
}