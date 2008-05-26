package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Graph;

// FIX 2394 stateful web instance - a central state holder, rather than a bunch of disparate maps
public interface StatefulWeb extends Web {
    <T> Graph<T> build(Class<T> root);
}
