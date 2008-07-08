package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImplProvider;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;

public final class ConcreteFactory implements Factory {
    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalArgumentException();
        Class cls = raw(site);
        Implementation impl = new DefaultImplementation(cls);
        return new ImplProvider(impl);

    }

    public boolean canHandle(InjectionSite site) {
        Class cls = raw(site);
        // FIX 2394 this is not correct, there needs to be a common class for determining what is concrete
        return !cls.isInterface();
    }

    private Class raw(InjectionSite site) {
        InjectionType type = site.type();
        return type.rawClass();
    }
}
