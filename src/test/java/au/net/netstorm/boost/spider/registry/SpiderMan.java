package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.linkage.Linkage;

public final class SpiderMan implements Factory {
    public boolean canHandle(Linkage linkage) {
        throw new UnsupportedOperationException();
    }

    public Blueprint get(Linkage linkage) {
        throw new UnsupportedOperationException();
    }
}
