package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.spider.linkage.Linkage;

public final class SpiderMan implements Factory {
    public boolean canHandle(Linkage linkage) {
        throw new UnsupportedOperationException();
    }

    public Blueprint get(Linkage linkage) {
        throw new UnsupportedOperationException();
    }
}
