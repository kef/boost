package au.net.netstorm.boost.nursery.statix;

import au.net.netstorm.boost.nursery.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.spider.core.Types;
import au.net.netstorm.boost.spider.core.Spider;

// OK ConstantName {
public final class Static {
    public static final Types types;

    static {
        Spider spider = spider();
        types = spider.resolve(Types.class);
    }

    private static Spider spider() {
        BoostSpiderBuilder builder = new DefaultBoostSpiderBuilder();
        return builder.build();
    }
}
// } OK ConstantName
