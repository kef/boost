package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.guts.InjectionSite;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public interface PartialProviderFactory extends ProviderFactory {
    boolean canHandle(InjectionSite site);
}
