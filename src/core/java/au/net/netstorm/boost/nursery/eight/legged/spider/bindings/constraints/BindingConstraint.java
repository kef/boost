package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Precedence;

public interface BindingConstraint {
    Precedence precedence();
    boolean accept(InjectionSite site);
}
