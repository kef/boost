package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultPostProcessor implements PostProcessor {
    private final Aspectorizer aspectorizer;
    private final Constructables constructables;

    public DefaultPostProcessor(Aspectorizer aspectorizer, Constructables constructables) {
        this.aspectorizer = aspectorizer;
        this.constructables = constructables;
    }
    
    public void process(Resolver resolver, Instances instances) {
        for (InjectionSite site : instances) {
            process(resolver, instances, site);
        }
    }

    // FIX 2394 this need a total rework. given new understanding of lifecycle and aspects.
    private void process(Resolver resolver, Instances instances, InjectionSite site) {
        Object instance = instances.get(site);
        Object replacement = aspectorizer.aspectorize(resolver, instance);
        if (instance != replacement) instances.replace(site, replacement);
        constructables.construct(instance);
    }
}
