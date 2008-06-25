package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

public interface BindingConstraintFactory {
    BindingConstraint nu();
    BindingConstraint nu(String name);
    BindingConstraint nu(Class<?> host);
    BindingConstraint nu(Class<?> host, String name);
}
