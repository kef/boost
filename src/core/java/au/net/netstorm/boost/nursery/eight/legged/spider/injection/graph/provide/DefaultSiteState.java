package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import java.util.HashSet;
import java.util.Set;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultSiteState implements SiteState {
    private Set<InjectionSite> walked = new HashSet<InjectionSite>();

    public void walking(InjectionSite site) {
        walked.add(site);
    }

    public boolean hasWalked(InjectionSite site) {
        return walked.contains(site);
    }
}
