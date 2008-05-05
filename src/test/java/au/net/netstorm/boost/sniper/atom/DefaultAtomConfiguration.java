package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Immutable;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.NullIntolerant;
import au.net.netstorm.boost.sniper.reflect.util.ClassTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.DefaultClassTestUtil;

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
