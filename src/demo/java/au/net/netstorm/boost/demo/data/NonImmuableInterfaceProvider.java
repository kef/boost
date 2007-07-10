package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.specific.SpecificProvider;

public class NonImmuableInterfaceProvider implements SpecificProvider {
    public Object get() {
        return new NonImmutableInterface() {
        };
    }
}
