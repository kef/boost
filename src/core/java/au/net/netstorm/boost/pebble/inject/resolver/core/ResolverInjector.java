package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;

public final class ResolverInjector implements Injector {
    private final EdgeField fielder = new DefaultEdgeField();
    private final ResolverFieldFinder fieldFinder;
    private final FieldResolver fieldResolver;

    public ResolverInjector(ResolverFieldFinder fieldFinder, FieldResolver fieldResolver) {
        this.fieldFinder = fieldFinder;
        this.fieldResolver = fieldResolver;
    }

    public void inject(Object ref) {
        Field[] fields = fieldFinder.find(ref);
        for (int i = 0; i < fields.length; i++) {
            inject(ref, fields[i]);
        }
    }

    private void inject(Object ref, Field field) {
        fieldResolver.resolve(field);
    }

    // FIX 1715 Remove when done.
}
