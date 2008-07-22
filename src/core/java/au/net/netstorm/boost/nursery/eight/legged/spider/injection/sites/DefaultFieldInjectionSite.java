package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;

public final class DefaultFieldInjectionSite extends Primordial implements FieldInjectionSite {
    // FIX 2394 smelly, is there any other way to exclude them from primordial goodness?
    private static final EdgeClass CLASSER = new DefaultEdgeClass();
    private static final EdgeField FIELDER = new DefaultEdgeField();
    private final InjectionSite delegate;

    public DefaultFieldInjectionSite(Class<?> host, InjectionType type, String name) {
        delegate = new DefaultConstructorInjectionSite(host, type, name);
    }

    public Class<?> host() {
        return delegate.host();
    }

    public InjectionType type() {
        return delegate.type();
    }

    public String name() {
        return delegate.name();
    }

    public boolean isConstrained() {
        return delegate.isConstrained();
    }

    // FIX 2394 abstract isWired and inject functionality
    public void inject(Object ref, Object resolved) {
        Field field = field();
        FIELDER.set(field, ref, resolved);
    }

    public boolean isWired(Object ref) {
        Field field = field();
        Object value = FIELDER.get(field, ref);
        return value != null;
    }

    private Field field() {
        Field field = CLASSER.getDeclaredField(host(), name());
        field.setAccessible(true);
        return field;
    }

}
