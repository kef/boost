package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultInjectorEngine implements InjectorEngine {
    private final EdgeField fielder = new DefaultEdgeField();
    private final ResolvableFieldFinder fieldFinder;
    private final FieldResolver fieldResolver;
    private final PartialInstances inProgress = new DefaultPartialInstances();

    public DefaultInjectorEngine(ResolvableFieldFinder fieldFinder, FieldResolver fieldResolver) {
        this.fieldFinder = fieldFinder;
        this.fieldResolver = fieldResolver;
    }

    public void inject(Interface iface, UnresolvedInstance unresolved) {
        inProgress.put(iface, unresolved);
        try {
            doInject(unresolved);
        }
        finally {
            inProgress.remove(iface);
        }
    }

    private void doInject(UnresolvedInstance unresolved) {
        Object ref = unresolved.getRef();
        Field[] fields = fieldFinder.find(ref);
        for (int i = 0; i < fields.length; i++) {
            inject(ref, fields[i]);
        }
    }

    private void inject(Object ref, Field field) {
        ResolvedInstance instance = fieldResolver.resolve(field);
        Object value = instance.getRef();
        fielder.set(field, ref, value);
    }
}
