package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public class DefaultAllowOverrides implements AllowOverrides {
    FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void withOverride(Runnable block) {
        try {
            fielder.setStatic(DefaultNiceMap.class, "overridesAllowed", true);
            block.run();
        } finally {
            fielder.setStatic(DefaultNiceMap.class, "overridesAllowed", false);
        }
    }
}
