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
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.SiteWalker;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.DefaultSiteWalker;

public final class DefaultLifecycleWirer implements StatelessGraphWirer {
    private final Wirer wirer;
    private final PostProcessor poster;
    private final SiteWalker walker;

    public DefaultLifecycleWirer(AspectResolver aspector) {
        poster = poster(aspector);
        wirer = wirer();
        walker = new DefaultSiteWalker();
    }

    public Lifecycle nu() {
        return new DefaultLifecycle(wirer, poster, walker);
    }

    private Wirer wirer() {
        Constructables constructables = new DefaultConstructables();
        return new DefaultWirer(constructables);
    }

    private PostProcessor poster(AspectResolver aspector) {
        Aspectorizer aspectorizer = new DefaultAspectorizer(aspector);
        return new DefaultPostProcessor(aspectorizer);
    }
}
