package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.lifecycle.Pokeable;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultPostProcessor implements PostProcessor {
    private final Aspectorizer aspectorizer;

    public DefaultPostProcessor(Aspectorizer aspectorizer) {
        this.aspectorizer = aspectorizer;
    }
    
    public void process(Resolver resolver, Instances instances) {
        for (InjectionSite site : instances) {
            process(resolver, instances, site);
        }
    }

    private void process(Resolver resolver, Instances instances, InjectionSite site) {
        Object instance = instances.get(site);
        Object replacement = aspectorizer.aspectorize(resolver, instance);
        if (instance != replacement) instances.replace(site, replacement);
        lifecycle(replacement);
    }

    private void lifecycle(Object ref) {
        if (!(ref instanceof Pokeable)) return;
        Pokeable pokeable = (Pokeable) ref;
        pokeable.poke();
    }
}
