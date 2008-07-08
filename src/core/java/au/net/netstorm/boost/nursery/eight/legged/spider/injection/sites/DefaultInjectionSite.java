package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeField;

public final class DefaultInjectionSite extends Primordial implements InjectionSite {
    // FIX 2394 smelly, is there any other way to exclude them from primordial goodness?
    private static final EdgeClass CLASSER = new DefaultEdgeClass();
    private static final EdgeField FIELDER = new DefaultEdgeField();
    private final Class<?> host;
    private final InjectionType type;
    private final String name;

    public DefaultInjectionSite(Class<?> host, InjectionType type, String name) {
        // FIX 2394 MAG Null checking.
        if (host == null || type == null || name == null) throw new IllegalArgumentException();
        this.host = host;
        this.type = type;
        this.name = name;
    }

    public Class<?> host() { return this.host; }
    public InjectionType type() { return this.type; }
    public String name() { return this.name; }

    // FIX 2394 abstract isWired and inject functionality
    // FIX 2394 name for o
    private boolean isWired(Object o) {
        Field field = field();
        Object value = FIELDER.get(field, o);
        return value != null;
    }

    // FIX 2394 name for o
    public void inject(Object o, Object instance) {
        if (isWired(o)) return;
        Field field = field();
        FIELDER.set(field, o, instance);
    }

    private Field field() {
        Field field = CLASSER.getDeclaredField(host, name);
        field.setAccessible(true);
        return field;
    }
}
