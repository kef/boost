package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;

public class ImplementationProvider implements DataProvider<Implementation> {
    public Implementation get() {
        return new DefaultImplementation(RandomClass.class);
    }

    private static class RandomClass {
    }
}
