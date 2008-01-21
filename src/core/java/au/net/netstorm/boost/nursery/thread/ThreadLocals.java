package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.NiceMap;

public interface ThreadLocals {
    void clear();

    NiceMap get();
}
