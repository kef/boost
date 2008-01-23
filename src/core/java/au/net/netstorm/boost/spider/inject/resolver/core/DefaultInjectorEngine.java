package au.net.netstorm.boost.spider.inject.resolver.core;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

import java.lang.reflect.Field;

public final class DefaultInjectorEngine implements InjectorEngine {
    private final EdgeField fielder = new DefaultEdgeField();
    private final ResolvableFieldFinder fieldFinder;
    private final FieldResolver fieldResolver;

    public DefaultInjectorEngine(ResolvableFieldFinder fieldFinder, FieldResolver fieldResolver) {
        this.fieldFinder = fieldFinder;
        this.fieldResolver = fieldResolver;
    }

    public void inject(UnresolvedInstance unresolved) {
        Object ref = unresolved.getRef();
        Field[] fields = fieldFinder.find(ref);
        inject(ref, fields);
    }

    private void inject(Object ref, Field[] fields) {
        for (Field field : fields) {
            inject(ref, field);
        }
    }

    private void inject(Object ref, Field field) {
        ResolvedInstance instance = fieldResolver.resolve(field);
        Object value = instance.getRef();
        // FIX ()  94156 Add all proxies/chains here???
        fielder.set(field, ref, value);
    }
}
