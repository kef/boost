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

public final class DefaultProtocolWirer implements ProtocolWirer {
    private final Wirer wirer = new DefaultWirer();
    private final PostProcessor poster;
    private final SiteWalker walker;

    public DefaultProtocolWirer(AspectResolver aspector) {
        poster = poster(aspector);
        walker = new DefaultSiteWalker();
    }

    public Protocol nu() {
        return new DefaultProtocol(wirer, poster, walker);
    }

    private PostProcessor poster(AspectResolver aspector) {
        Aspectorizer aspectorizer = new DefaultAspectorizer(aspector);
        Constructables constructables = new DefaultConstructables();
        return new DefaultPostProcessor(aspectorizer, constructables);
    }
}
