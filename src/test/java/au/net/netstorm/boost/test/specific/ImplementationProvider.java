package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;

public class ImplementationProvider implements DataProvider<Implementation> {
    public Implementation get() {
        return new DefaultImplementation(RandomClass.class);
    }

    private static class RandomClass {
    }
}
