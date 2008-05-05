package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;

public class ImplementationProvider implements DataProvider<Implementation> {
    public Implementation get() {
        return new DefaultImplementation(RandomClass.class);
    }

    private static class RandomClass {
    }
}
