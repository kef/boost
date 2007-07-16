package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultInterface;

public class InterfaceSpecificProvider implements DataProvider {

    public Data get() {
        return new DefaultInterface(RandomInterface.class);
    }

    private static interface RandomInterface {
    }
}
