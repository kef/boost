package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve;

import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core.CannotProvideException;

public final class ResolutionFailer implements Failer<InjectionSite> {
    public void fail(InjectionSite site) {
        throw new CannotProvideException(site);
    }
}
