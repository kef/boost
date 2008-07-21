package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspectorizer;

public final class DefaultPostProcessor implements PostProcessor {
    // FIX 2394 use or lose. post process action should aspectorize each instance.
    private final Aspectorizer aspectorizer;

    public DefaultPostProcessor(Aspectorizer aspectorizer) {
        this.aspectorizer = aspectorizer;
    }

    public void process(Instances instances) {
        // FIX 2394 implement.
    }
}
