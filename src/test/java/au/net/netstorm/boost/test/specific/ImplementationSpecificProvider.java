package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultImplementation;

public class ImplementationSpecificProvider implements DataProvider {

    public Data get() {
        return new DefaultImplementation(RandomClass.class);
    }

    private static class RandomClass {
    }
}
