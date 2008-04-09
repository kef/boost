package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public class DefaultAllowOverrides implements AllowOverrides {
    FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void withOverride(Runnable block) {
        try {
            fielder.setStatic(DefaultStrictMap.class, "overridesAllowed", true);
            block.run();
        } finally {
            fielder.setStatic(DefaultStrictMap.class, "overridesAllowed", false);
        }
    }
}
