package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;

public interface Aspectorizer {
    Object aspectorize(Providers providers, Object target);
}
