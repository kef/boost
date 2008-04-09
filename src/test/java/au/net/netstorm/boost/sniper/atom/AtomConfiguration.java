package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.type.Interface;

public interface AtomConfiguration {
    boolean checkNulls();

    boolean checkImmutable();

    Interface getType();
}
