package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.register.Blueprint;
import au.net.netstorm.boost.spider.register.DefaultBlueprint;
import au.net.netstorm.boost.spider.register.Factory;
import static au.net.netstorm.boost.spider.register.Stamp.MULTIPLE;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class MemorabiliaFactory implements Factory {
    private static final Interface MEMORABILIA = new DefaultInterface(Memorabilia.class);
    private static final Implementation STOLEN = new DefaultImplementation(StolenMemorabilia.class);

    public Blueprint get(Linkage linkage) {
        Implementation host = linkage.getHost();
        Class cls = host.getImpl();
        Object[] args = {cls};
        return new DefaultBlueprint(MULTIPLE, STOLEN, args);
    }

    public boolean canHandle(Linkage linkage) {
        Object iface = linkage.getIface();
        return MEMORABILIA.equals(iface);
    }
}
