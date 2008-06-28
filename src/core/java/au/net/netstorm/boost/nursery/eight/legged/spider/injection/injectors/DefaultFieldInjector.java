package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.lang.reflect.Field;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionContext;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;

public final class DefaultFieldInjector implements MemberInjector {
    private final EdgeField fielder = new DefaultEdgeField();
    private final Injection injection;
    private final Field field;

    public DefaultFieldInjector(Injection injection, Field field) {
        this.injection = injection;
        this.field = field;
    }

    public void inject(InjectionContext context, Object instance) {
        Object old = fielder.get(field, instance);
        if (old != null) return;
        doInjection(context, instance);
    }

    private void doInjection(InjectionContext context, Object instance) {
        Object value = injection.apply(context);
        fielder.set(field, instance, value);
    }
}