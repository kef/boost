package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class ResolutionFailer implements Failer<InjectionSite> {
    public void fail(InjectionSite site) {
        throw new CannotProvideException(site);
    }
}
