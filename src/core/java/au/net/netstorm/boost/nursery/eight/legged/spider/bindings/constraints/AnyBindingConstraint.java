package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class AnyBindingConstraint implements BindingConstraint {
    public boolean accept(InjectionSite site) {
        return true;
    }
}
