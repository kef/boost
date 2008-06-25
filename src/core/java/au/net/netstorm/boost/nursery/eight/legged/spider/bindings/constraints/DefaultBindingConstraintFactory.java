package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

public final class DefaultBindingConstraintFactory implements BindingConstraintFactory {
    public BindingConstraint nu() {
        return new AnyBindingConstraint();
    }

    public BindingConstraint nu(String name) {
        return new NamedBindingConstraint(name);
    }

    public BindingConstraint nu(Class<?> host) {
        return new HostedBindingConstraint(host);
    }

    public BindingConstraint nu(Class<?> host, String name) {
        return new HostedAndNamedBindingConstraint(host, name);
    }
}
