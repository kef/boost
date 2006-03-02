package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassMaster {
    String getShortName(Class cls);

    String getShortName(Interface iface);
}
