package au.net.netstorm.boost.bullet.mirror;

import au.net.netstorm.boost.gunge.type.Interface;

public interface ClassMaster {
    String getShortName(Interface iface);

    String getShortName(Class cls);

    String getPackageName(Interface iface);

    String getPackageName(Class cls);
}
