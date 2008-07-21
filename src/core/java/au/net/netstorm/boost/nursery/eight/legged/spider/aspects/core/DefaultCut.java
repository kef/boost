package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

// FIX 2394 use or lose. wire in to be injected into aspect constructor.
public final class DefaultCut implements Cut {
    private final Aspect[] links;
    private final Object core;

    public DefaultCut(Aspect[] links, Object core) {
        this.links = links;
        this.core = core;
    }

    public Aspect[] links() {
        return links;
    }

    public Object core() {
        return core;
    }
}
