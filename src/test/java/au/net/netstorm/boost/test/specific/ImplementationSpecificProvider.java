package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.test.random.RandomProvider;
import au.net.netstorm.boost.util.type.DefaultImplementation;

public class ImplementationSpecificProvider implements SpecificProvider {
    private RandomProvider random;

    public ImplementationSpecificProvider(RandomProvider random) {
        this.random = random;
    }

    public Object get() {
        Class aClass = (Class) random.provide(Class.class);
        while (aClass.isInterface()) {
            aClass = (Class) random.provide(Class.class);
        }
        return new DefaultImplementation(aClass);
    }
}
