package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultPostProcessor implements PostProcessor {
    private final Aspectorizer aspectorizer;

    public DefaultPostProcessor(Aspectorizer aspectorizer) {
        this.aspectorizer = aspectorizer;
    }

    public void process(Instances instances) {
        for (InjectionSite site : instances) {
            process(instances, site);
        }
    }

    private void process(Instances instances, InjectionSite site) {
        Object instance = instances.get(site);
        Object replacement = aspectorizer.aspectorize(instance);
        if (instance != replacement) instances.replace(site, replacement);
        // FIX 2394 MAG also suggested that you could do eager poking of aspects here as well.
        // FIX 2394 e.g. Construct all constructables.
    }
}
