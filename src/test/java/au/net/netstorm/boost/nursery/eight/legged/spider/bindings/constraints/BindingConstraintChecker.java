package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface BindingConstraintChecker {
    void checkAccept(boolean expected, BindingConstraint constraint, InjectionSite site);
}
