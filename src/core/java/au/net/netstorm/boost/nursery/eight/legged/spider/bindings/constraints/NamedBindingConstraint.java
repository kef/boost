package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class NamedBindingConstraint implements BindingConstraint {
    private final String name;

    public NamedBindingConstraint(String name) {
        this.name = name;
    }

    public boolean accept(InjectionSite site) {
        String actual = site.name();
        return name.equals(actual);
    }
}
