package au.net.netstorm.boost.util.reflect;

public class DefaultClassMaster implements ClassMaster {
    public String getShortName(Class cls) {
        String clsName = cls.getName();
        int lastPeriod = clsName.lastIndexOf('.');
        return clsName.substring(lastPeriod + 1);
    }
}
