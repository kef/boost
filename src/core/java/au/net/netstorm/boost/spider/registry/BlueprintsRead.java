package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.linkage.Linkage;

public interface BlueprintsRead {
    Blueprint get(Linkage linkage);

    boolean exists(Linkage linkage);
}
