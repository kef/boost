package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.gunge.collection.Failer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.CannotProvideException;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 Remove dup with ResolutionFailer.
public final class ProvisionFailer implements Failer<InjectionSite, Provider> {
    public Provider apply(InjectionSite site) {
        throw new CannotProvideException(site);
    }
}
