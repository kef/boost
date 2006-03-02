package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

public class DefaultClassMaster implements ClassMaster {
    public String getShortName(Class cls) {
        String clsName = cls.getName();
        int lastPeriod = clsName.lastIndexOf('.');
        return clsName.substring(lastPeriod + 1);
    }

    public String getShortName(Interface iface) {
        Class type = iface.getType();
        return getShortName(type);
    }
}
