package au.net.netstorm.boost.nursery.typetokens;

import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factory;

public class TypeRFactory implements Factory {
    public boolean canHandle(Linkage linkage) {
        return false;
    }

    public Blueprint get(Linkage linkage) {
        return null;
    }

}
