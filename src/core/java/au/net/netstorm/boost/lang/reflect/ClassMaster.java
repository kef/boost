package au.net.netstorm.boost.lang.reflect;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassMaster {
    String getShortName(Interface iface);

    String getShortName(Class cls);
}
