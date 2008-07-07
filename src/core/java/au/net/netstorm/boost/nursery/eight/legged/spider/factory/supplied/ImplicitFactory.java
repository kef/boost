package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImplProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.support.EdgeException;

public final class ImplicitFactory implements ConfigurableFactory {
    private final Mappings mappings = new DefaultMappings();
    private final EdgeClass classer = new DefaultEdgeClass();

    public void configure(Binder binder) {
        binder.bind(Mappings.class).to(mappings);
    }

    public Provider nu(InjectionSite site) {
        InjectionType type = site.type();
        for (Mapping mapping : mappings) {
            if (providable(type, mapping)) return provider(type, mapping);
        }
        throw new IllegalArgumentException();
    }

    public boolean canHandle(InjectionSite site) {
        InjectionType type = site.type();
        for (Mapping mapping : mappings) {
            if (providable(type, mapping)) return true;
        }
        return false;
    }

    private boolean providable(InjectionType type, Mapping mapping) {
        return mapping.can(type) && exists(type, mapping);
    }

    // FIX 2394 I am an ugly bastard.  And something does already exist.
    // FIX 2394 i am sure something like this would already exist
    private boolean exists(InjectionType type, Mapping mapping) {
        String target = mapping.map(type);
        try {
            classer.forName(target);
            return true;
        } catch (EdgeException e) {
            return false;
        }
    }

    private Provider provider(InjectionType type, Mapping mapping) {
        String target = mapping.map(type);
        Class cls = classer.forName(target);
        Implementation impl = new DefaultImplementation(cls);
        return new ImplProvider(impl);
    }
}
