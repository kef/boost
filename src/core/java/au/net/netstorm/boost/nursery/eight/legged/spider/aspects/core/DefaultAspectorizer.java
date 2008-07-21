package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;

public final class DefaultAspectorizer implements Aspectorizer {
    private final AspectResolver resolver;

    public DefaultAspectorizer(AspectResolver resolver) {
        this.resolver = resolver;
    }

    public Object aspectorize(Object target) {
        AspectType type = resolver.resolve(target);
        return type.hasLayers() ? aspect(target, type) : target;
    }

    // FIX BREADCRUMB 2394 aaaaaaaaaaa implement me.
    private Object aspect(Object target, AspectType type) {
        return target;
    }
}
