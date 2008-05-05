package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;

public class InterfaceProvider implements DataProvider<Interface> {
    public Interface get() {
        return new DefaultInterface(RandomInterface.class);
    }

    private static interface RandomInterface {
    }
}
