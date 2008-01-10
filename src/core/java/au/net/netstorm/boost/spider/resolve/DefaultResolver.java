package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.nursery.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.nursery.spider.linkage.Linkage;
import au.net.netstorm.boost.nursery.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolver implements Resolver {
    private final LinkageFactory linkages = new DefaultLinkageFactory();
    private final ResolverEngine engine;

    public DefaultResolver(ResolverEngine engine) {
        this.engine = engine;
    }

    public <T> T resolve(Class<T> type) {
        Linkage linkage = linkages.nu(type);
        ResolvedInstance resolved = engine.resolve(linkage);
        Object o = resolved.getRef();
        return type.cast(o);
    }
}
