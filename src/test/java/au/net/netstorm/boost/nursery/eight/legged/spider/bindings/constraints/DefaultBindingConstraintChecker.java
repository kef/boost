package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import static junit.framework.Assert.assertEquals;

public final class DefaultBindingConstraintChecker implements BindingConstraintChecker {
    public void checkAccept(boolean expected, BindingConstraint constraint, InjectionSite site) {
        boolean result = constraint.accept(site);
        assertEquals(expected, result);
    }
}
