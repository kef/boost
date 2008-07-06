package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Precedence;

public final class AnyBindingConstraint implements BindingConstraint {
    public Precedence precedence() {
        return Precedence.RAW;
    }

    public boolean accept(InjectionSite site) {
        return true;
    }
}
