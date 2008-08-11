package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.spider.resolve.Resolver;

public interface Aspectorizer {
    Object aspectorize(Resolver resolver, Object target);
}
