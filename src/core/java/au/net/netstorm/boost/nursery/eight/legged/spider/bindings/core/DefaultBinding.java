package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraint;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.SingletonFactory;
import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultBinding extends Primordial implements MutableBinding {
    private final InjectionType type;
    private final BindingConstraint constraint;
    private final Precedence precedence;
    private Factory factory;

    // FIX 2394 not thread safe, probably should be made so by making factory an atomic ref
    public DefaultBinding(InjectionType type, BindingConstraint constraint, Precedence precedence) {
        if (type == null || constraint == null || precedence == null) throw new IllegalArgumentException();
        this.type = type;
        this.constraint = constraint;
        this.precedence = precedence;
    }

    public boolean accepts(InjectionSite site) {
        validate();
        return constraint.accept(site) && factory.canHandle(site);
    }

    public void makeSingleton() {
        factory = new SingletonFactory(factory);
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Factory getFactory(InjectionSite site) {
        if (!accepts(site)) throw new IllegalStateException("Factory only accessible if binding 'accepts' site.");
        return factory;
    }

    public Precedence getPrecedence() {
        return precedence;
    }

    public InjectionType getType() {
        return type;
    }

    private void validate() {
        if (factory == null) throw new IllegalStateException("Binding target is not set.");
    }
}
