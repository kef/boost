package au.net.netstorm.boost.nursery.statix;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.nursery.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.spider.instantiate.Nu;

// OK ConstantName {
public final class Static {
    public static final Types types;
    public static final Nu nu;

    static {
        Spider spider = spider();
        types = spider.resolve(Types.class);
        nu = spider.resolve(Nu.class);
    }

    private static Spider spider() {
        BoostSpiderBuilder builder = new DefaultBoostSpiderBuilder();
        return builder.build();
    }
}
// } OK ConstantName
