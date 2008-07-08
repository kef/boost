package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

// FIX BREADCRUMB 2394 aaaaaaa push split through, been split into lifecycle and state, but Graph still used everywhere
// FIX 2394 use or lose. stores state of graph construction/traversal.
public interface Graph extends GraphLifecycle, GraphState {
}
