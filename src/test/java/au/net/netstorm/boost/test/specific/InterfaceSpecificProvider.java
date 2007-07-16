package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultInterface;

// FIX 2076 What does this do.
public class InterfaceSpecificProvider implements DataProvider {

    public Data get() {
        return new DefaultInterface(RandomInterface.class);
    }

    private static interface RandomInterface {
    }
}
