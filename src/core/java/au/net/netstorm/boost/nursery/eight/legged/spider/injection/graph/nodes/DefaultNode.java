package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. wire into site walker build dependency graph of nodes.
// FIX 2394 this approach is better suited to handling aspects and lifecycles.
public final class DefaultNode implements Node {
    private final List<Node> children = new ArrayList<Node>();
    private final InjectionSite site;

    public DefaultNode(InjectionSite site) {
        this.site = site;
    }

    public void add(Node child) {
        children.add(child);
    }

    public InjectionSite site() {
        return site;
    }

    public Iterator iterator() {
        return children.iterator();
    }
}
