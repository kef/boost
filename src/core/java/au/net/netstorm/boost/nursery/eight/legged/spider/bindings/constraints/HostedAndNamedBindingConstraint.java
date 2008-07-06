package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Precedence;

public final class HostedAndNamedBindingConstraint implements BindingConstraint {
    private final BindingConstraint host;
    private final BindingConstraint name;

    public HostedAndNamedBindingConstraint(Class<?> host, String name) {
        this.host = new HostedBindingConstraint(host);
        this.name = new NamedBindingConstraint(name);
    }

    public Precedence precedence() {
        return Precedence.HOSTED_AND_NAMED;
    }

    public boolean accept(InjectionSite site) {
        return host.accept(site) && name.accept(site);
    }
}
