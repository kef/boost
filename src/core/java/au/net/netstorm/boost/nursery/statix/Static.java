package au.net.netstorm.boost.nursery.statix;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.nursery.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.nursery.type.core.Types;

// OK ConstantName {
public final class Static {
    public static final Types types;

    static {
        BoostSpiderBuilder builder = new DefaultBoostSpiderBuilder();
        Spider spider = builder.build();
        types = spider.resolve(Types.class);
    }
}
// } OK ConstantName
