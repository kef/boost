package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Precedence;

public final class HostedBindingConstraint implements BindingConstraint {
    private final Class<?> host;

    public HostedBindingConstraint(Class<?> host) {
        this.host = host;
    }

    public Precedence precedence() {
        return Precedence.HOSTED;
    }

    public boolean accept(InjectionSite site) {
        Class<?> actual = site.host();
        return host.equals(actual);
    }
}
