package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.Constructables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.DefaultConstructables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.DefaultPostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.DefaultWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.Wirer;

public final class DefaultLifecycleWirer implements StatelessGraphWirer {
    private final Wirer wirer = new DefaultWirer();
    private final PostProcessor poster;

    public DefaultLifecycleWirer(AspectResolver aspector) {
        poster = poster(aspector);
    }

    public Lifecycle nu() {
        return new DefaultLifecycle(wirer, poster);
    }

    private PostProcessor poster(AspectResolver aspector) {
        Aspectorizer aspectorizer = new DefaultAspectorizer(aspector);
        Constructables constructables = new DefaultConstructables();
        return new DefaultPostProcessor(aspectorizer, constructables);
    }
}
