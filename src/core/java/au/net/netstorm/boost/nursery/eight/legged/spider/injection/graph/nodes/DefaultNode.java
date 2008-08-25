package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes;

import java.util.LinkedList;
import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 make primordial, currently blows up on recursive children.
public final class DefaultNode implements Node {
    private final List<Node> children = new LinkedList<Node>();
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

    public boolean available() {
        return children.size() > 0;
    }

    public Node take() {
        return children.remove(0);
    }
}
