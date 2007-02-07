package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.util.type.Interface;

// FIX SC600 Doesn't work for Object[], gives "Object;"  Java 1.5 would solve this with .getSimpleName().
public class DefaultClassMaster implements ClassMaster {
    public String getShortName(Interface iface) {
        Class type = iface.getType();
        return getShortName(type);
    }

    public String getShortName(Class cls) {
        String clsName = cls.getName();
        int lastPeriod = clsName.lastIndexOf('.');
        return clsName.substring(lastPeriod + 1);
    }

    public String getPackageName(Interface iface) {
        Class type = iface.getType();
        return getPackageName(type);
    }

    public String getPackageName(Class cls) {
        String fullName = cls.getName();
        int lastDot = fullName.lastIndexOf(".");
        return fullName.substring(0, lastDot);
    }
}
