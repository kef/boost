package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.util.type.DefaultInterface;

public class InterfaceSpecificProvider implements SpecificProvider {
    private Provider random;

    public InterfaceSpecificProvider(Provider random) {
        this.random = random;
    }

    public Object get() {
        Class iFace = (Class) random.provide(Class.class);
        while (!iFace.isInterface()) {
            iFace = (Class) random.provide(Class.class);
        }
        return new DefaultInterface(iFace);
    }
}
