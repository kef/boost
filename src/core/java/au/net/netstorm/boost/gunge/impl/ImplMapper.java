package au.net.netstorm.boost.gunge.impl;

import au.net.netstorm.boost.gunge.type.Interface;

public interface ImplMapper {
    String map(Interface iface);

    boolean can(Interface iface);
}
