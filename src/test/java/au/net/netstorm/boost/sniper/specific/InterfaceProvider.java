package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public class InterfaceProvider implements DataProvider<Interface> {
    public Interface get() {
        return new DefaultInterface(RandomInterface.class);
    }

    private static interface RandomInterface {
    }
}
