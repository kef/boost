package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.UnresolvableException;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSiteBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.DefaultInjectionSiteBuilder;
import au.net.netstorm.boost.bullet.primordial.Primordial;

// FIX 2394 Do something about this. How are arrays to be handled.
public final class ArrayInjectionType extends Primordial implements InjectionType {
    private final InjectionSiteBuilder sites = new DefaultInjectionSiteBuilder();
    public InjectionType raw() {
        barf();
        throw new IllegalStateException();
    }

    public InjectionType[] parameters() {
        barf();
        throw new IllegalStateException();
    }

    public Class rawClass() {
        barf();
        throw new IllegalStateException();
    }

    private InjectionType barf() {
        InjectionSite site = sites.root(this);
        throw new UnresolvableException(site);
    }

    public boolean isInterface() {
        return false;
    }
}
