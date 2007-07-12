package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.specific.TargettedProvider;

public class NonImmuableInterfaceProvider implements TargettedProvider {
    public Object get() {
        return new NonImmutableInterface() {
        };
    }
}
