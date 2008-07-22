package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspectorizer;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.DefaultInstantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instantiator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.DefaultPostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess.PostProcessor;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.DefaultWirer;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire.Wirer;

// FIX 2394 fix this mess.
// OK ClassDataAbstractionCoupling {
public final class DefaultGraphWirer implements GraphWirer {
    private final Instantiator instantiator = new DefaultInstantiator();
    private final Wirer wirer = new DefaultWirer();
    private final PostProcessor poster;

    public DefaultGraphWirer(AspectResolver aspector) {
        poster = nu(aspector);
    }

    public Graph wire() {
        return new DefaultGraph(instantiator, wirer, poster);
    }

    private PostProcessor nu(AspectResolver poster) {
        Aspectorizer aspectorizer = new DefaultAspectorizer(poster);
        return new DefaultPostProcessor(aspectorizer);
    }
}
// } OK ClassDataAbstractionCoupling