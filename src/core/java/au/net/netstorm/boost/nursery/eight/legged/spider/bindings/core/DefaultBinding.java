package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraint;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultBinding extends Primordial implements MutableBinding {
    private final InjectionType type;
    private final BindingConstraint constraint;
    private Factory factory;

    public DefaultBinding(InjectionType type, BindingConstraint constraint) {
        if (type == null || constraint == null) throw new IllegalArgumentException();
        this.type = type;
        this.constraint = constraint;
    }

    public boolean accepts(InjectionSite site) {
        validate();
        return constraint.accept(site) && factory.canHandle(site);
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Factory getFactory(InjectionSite site) {
        if (!accepts(site)) throw new IllegalStateException("Factory only accessible if binding 'accepts' site.");
        return factory;
    }

    public Precedence getPrecedence() {
        return constraint.precedence();
    }

    public InjectionType getType() {
        return type;
    }

    private void validate() {
        if (factory == null) throw new IllegalStateException("Binding target is not set: " + this);
    }
}
