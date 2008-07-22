package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2394 use or lose. wire in to be injected into aspect constructor.
// FIX 2394 use a builder mutable-> immutable pattern here.
public final class DefaultCut implements Cut {
    private final List<Layer> links = new ArrayList<Layer>();
    private final Object core;
    private Layer outer;

    public DefaultCut(Object core) {
        this.core = core;
    }

    // FIX 2394 split into mutable and immutable ifaces.
    public void add(Layer aspect) {
        links.add(aspect);
        outer = aspect;
    }

    public Layer outer() {
        return outer;
    }

    public List<Layer> links() {
        return links;
    }

    public Object core() {
        return core;
    }
}
