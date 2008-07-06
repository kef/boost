package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraint;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraintFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.DefaultBindingConstraintFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.DefaultBinding;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.MutableBinding;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;

public final class DefaultBinder implements Binder {
    private final BindingConstraintFactory constraints = new DefaultBindingConstraintFactory();
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final Bindings bindings;

    public DefaultBinder(Bindings bindings) {
        this.bindings = bindings;
    }

    public <T> Target<T> bind(Class<T> iface, Class<?> host, String name) {
        InjectionType type = typer.build(iface);
        return bind(type, host, name);
    }

    public <T> Target<T> bind(Class<T> iface, Class<?> host) {
        InjectionType type = typer.build(iface);
        return bind(type, host);
    }

    public <T> Target<T> bind(Class<T> iface, String name) {
        InjectionType type = typer.build(iface);
        return bind(type, name);
    }

    public <T> Target<T> bind(Class<T> iface) {
        InjectionType type = typer.build(iface);
        return bind(type);
    }

    public <T> Target<T> bind(InjectionType<T> type, Class<?> host, String name) {
        BindingConstraint constraint = constraints.nu(host, name);
        return buildTarget(type, constraint);
    }

    public <T> Target<T> bind(InjectionType<T> type, Class<?> host) {
        BindingConstraint constraint = constraints.nu(host);
        return buildTarget(type, constraint);
    }

    public <T> Target<T> bind(InjectionType<T> type, String name) {
        BindingConstraint constraint = constraints.nu(name);
        return buildTarget(type, constraint);
    }

    public <T> Target<T> bind(InjectionType<T> type) {
        BindingConstraint constraint = constraints.nu();
        // FIX 2394 should the precedence be set against the constraint? prob yes
        return buildTarget(type, constraint);
    }

    private <T> Target<T> buildTarget(InjectionType<T> type, BindingConstraint constraint) {
        MutableBinding binding = new DefaultBinding(type, constraint);
        bindings.add(binding);
        return new DefaultTarget<T>(binding);
    }
}
