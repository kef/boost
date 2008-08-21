package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.spider.onion.core.Layer;

import java.util.ArrayList;
import java.util.List;
// FIX 2394 Split into mutable and immutable ifaces.
// FIX 2394 Use a builder mutable-> immutable pattern.
public final class DefaultCut implements Cut {
    private final List<Layer> links = new ArrayList<Layer>();
    private final Object core;
    private Layer outer;

    public DefaultCut(Object core) {
        this.core = core;
    }

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
