package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.spider.resolve.Resolver;

public final class DefaultPostProcessor implements PostProcessor {
    private final Constructables constructables;
    private final Aspectorizer aspectorizer;

    public DefaultPostProcessor(Aspectorizer aspectorizer, Constructables constructables) {
        this.aspectorizer = aspectorizer;
        this.constructables = constructables;
    }

    // FIX 2394 consolidate into one loop.
    public void process(Resolver resolver, Instances instances) {
        for (Object ref : instances.inOrder()) {
            constructables.construct(ref);
        }
        for (InjectionSite site : instances) {
            aspects(resolver, instances, site);
        }
    }

    private void aspects(Resolver resolver, Instances instances, InjectionSite site) {
        Object instance = instances.get(site);
        Object replacement = aspectorizer.aspectorize(resolver, instance);
        if (instance != replacement) instances.replace(site, replacement);
    }
}
