package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.StrictMap;

public interface ThreadLocals {
    void clear();

    StrictMap get();
}
