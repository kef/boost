package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.DefaultNode;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class DefaultSiteWalker implements SiteWalker {
    private final Walker constructor = new DefaultConstructorWalker();
    private final Walker fields = new DefaultFieldWalker();
    private final Providers providers;
    private final Resolvables resolvables;

    public DefaultSiteWalker(Providers providers, Resolvables resolvables) {
        this.providers = providers;
        this.resolvables = resolvables;
    }

    public Node traverse(InjectionSite site) {
        SiteState state = new DefaultSiteState();
        Node root = new DefaultNode(site);
        traverse(root, state, site);
        return root;
    }

    public void traverse(Node node, SiteState state, InjectionSite host, InjectionSite[] sites) {
        resolvables.add(host, sites);
        for (InjectionSite site : sites) branch(node, state, site);
    }

    private void branch(Node parent, SiteState state, InjectionSite site) {
        Node child = new DefaultNode(site);
        parent.add(child);
        traverse(child, state, site);
    }

    public void traverse(Node node, SiteState state, InjectionSite site) {
        if (state.hasWalked(site)) return;
        state.walking(site);
        safeTraverse(node, state, site);
    }

    private void safeTraverse(Node node, SiteState state, InjectionSite site) {
        try {
            unsafeTraverse(node, state, site);
        } catch (Exception ignore) {
            // FIX 2394 Fix this crud. Basically don't care at this stage if it can't provide.
            // FIX 2394 This gets validated in next phase (could be created by constructor/initializer).
        }
    }

    private void unsafeTraverse(Node node, SiteState state, InjectionSite site) {
        Provider provider = providers.provide(site);
        constructor.traverse(this, node, state, site, provider);
        fields.traverse(this, node, state, site, provider);
    }
}
