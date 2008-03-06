package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.test.reflect.util.ClassTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultClassTestUtil;
import au.net.netstorm.boost.util.type.Immutable;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.NullIntolerant;

public final class DefaultAtomConfiguration implements AtomConfiguration {
    private static final Interface NULL_INTOLERANT = new DefaultInterface(NullIntolerant.class);
    private static final Interface IMMUTABLE = new DefaultInterface(Immutable.class);
    private final ClassTestUtil classer = new DefaultClassTestUtil();
    private final Interface type;

    public DefaultAtomConfiguration(Class type) {
        this.type = new DefaultInterface(type);
    }

    public boolean checkNulls() {
        return classer.isSubInterfaceOf(NULL_INTOLERANT, type);
    }

    public boolean checkImmutable() {
        return classer.isSubInterfaceOf(IMMUTABLE, type);
    }

    public Interface getType() {
        return type;
    }
}
