package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.inject.core.InjectorEngine;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.util.type.UnresolvedInstance;
import au.net.netstorm.boost.util.type.WrappedInstance;

public final class ResolverInjectorEngine implements InjectorEngine {
    private final EdgeField fielder = new DefaultEdgeField();
    private final ResolverFieldFinder fieldFinder;
    private final FieldResolver fieldResolver;

    public ResolverInjectorEngine(ResolverFieldFinder fieldFinder, FieldResolver fieldResolver) {
        this.fieldFinder = fieldFinder;
        this.fieldResolver = fieldResolver;
    }

    public void inject(UnresolvedInstance unresolved) {
        Object ref = unresolved.getRef();
        Field[] fields = fieldFinder.find(ref);
        for (int i = 0; i < fields.length; i++) {
            inject(ref, fields[i]);
        }
    }

    private void inject(Object ref, Field field) {
        WrappedInstance instance = fieldResolver.resolve(field);
        Object value = instance.getRef();
        fielder.set(field, ref, value);
    }
}
