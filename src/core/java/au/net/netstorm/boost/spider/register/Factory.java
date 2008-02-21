package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.spider.linkage.Linkage;

public interface Factory {
    Blueprint get(Linkage linkage);

    boolean canHandle(Linkage linkage);
}
