package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import java.util.List;
import java.util.ArrayList;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultUnresolvables implements Unresolvables {
    private final List<InjectionSite> sites = new ArrayList<InjectionSite>();

    public void add(InjectionSite site) {
        sites.add(site);
    }
}
