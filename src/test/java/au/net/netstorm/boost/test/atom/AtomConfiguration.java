package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.type.Interface;

public interface AtomConfiguration {
    boolean checkNulls();

    boolean checkImmutable();

    Interface getType();
}
