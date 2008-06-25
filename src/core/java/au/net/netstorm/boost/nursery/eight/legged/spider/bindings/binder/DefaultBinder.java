package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraint;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraintFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.DefaultBindingConstraintFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Precedence;
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

    public Target bind(Class<?> iface, Class<?> host, String name) {
        InjectionType type = typer.build(iface);
        return bind(type, host, name);
    }

    public Target bind(Class<?> iface, Class<?> host) {
        InjectionType type = typer.build(iface);
        return bind(type, host);
    }

    public Target bind(Class<?> iface, String name) {
        InjectionType type = typer.build(iface);
        return bind(type, name);
    }

    public Target bind(Class<?> iface) {
        InjectionType type = typer.build(iface);
        return bind(type);
    }

    public Target bind(InjectionType type, Class<?> host, String name) {
        BindingConstraint constraint = constraints.nu(host, name);
        return buildTarget(type, constraint, Precedence.HOSTED_AND_NAMED);
    }

    public Target bind(InjectionType type, Class<?> host) {
        BindingConstraint constraint = constraints.nu(host);
        return buildTarget(type, constraint, Precedence.HOSTED);
    }

    public Target bind(InjectionType type, String name) {
        BindingConstraint constraint = constraints.nu(name);
        return buildTarget(type, constraint, Precedence.NAMED);
    }

    public Target bind(InjectionType type) {
        BindingConstraint constraint = constraints.nu();
        // FIX INIT should the precedence be set against the constraint? prob yes
        return buildTarget(type, constraint, Precedence.RAW);
    }

    private Target buildTarget(InjectionType type, BindingConstraint constraint, Precedence precedence) {
        MutableBinding binding = new DefaultBinding(type, constraint, precedence);
        bindings.add(binding);
        return new DefaultTarget(binding);
    }
}
