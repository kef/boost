package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.linkage.Linkage;

public interface Factory {
    Blueprint get(Linkage linkage);

    boolean canHandle(Linkage linkage);
}
