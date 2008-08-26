package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.data.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.data.DefaultNode;

public final class DefaultSiteState implements SiteState {
    private final Set<InjectionSite> walked = new HashSet<InjectionSite>();
    // FIX 2394 Use integrity map.
    private final Map<InjectionSite, Node> nodes = new HashMap<InjectionSite, Node>();
    private final Providers providers;

    public DefaultSiteState(Providers providers) {
        this.providers = providers;
    }

    public void walking(InjectionSite site) {
        walked.add(site);
    }

    public boolean hasWalked(InjectionSite site) {
        return walked.contains(site);
    }

    public Node lookup(InjectionSite site) {
        return nodes.containsKey(site) ? nodes.get(site) : nuNode(site);
    }

    public Providers providers() {
        return this.providers;
    }

    private Node nuNode(InjectionSite site) {
        Node child = new DefaultNode(site);
        nodes.put(site, child);
        return child;
    }
}
