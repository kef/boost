package au.net.netstorm.boost.nursery.statix;

import au.net.netstorm.boost.nursery.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.spider.core.Spider;

// OK ConstantName {
public final class Static {
    public static final Nu NU;

    static {
        Spider spider = spider();
        NU = spider.resolve(Nu.class);
    }

    private static Spider spider() {
        BoostSpiderBuilder builder = new DefaultBoostSpiderBuilder();
        return builder.build();
    }
}
// } OK ConstantName
