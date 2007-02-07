package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassMaster {
    String getShortName(Interface iface);

    String getShortName(Class cls);

    String getPackageName(Interface iface);

    String getPackageName(Class cls);
}
