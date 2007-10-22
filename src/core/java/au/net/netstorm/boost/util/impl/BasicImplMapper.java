package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.type.Interface;

public final class BasicImplMapper implements ImplMapper {
    private ClassMaster master = new DefaultClassMaster();

    public String map(Interface iface) {
        String pkg = master.getPackageName(iface);
        String cls = master.getShortName(iface);
        return pkg + "." + "Default" + cls;
    }

    public boolean can(Interface iface) {
        return true;
    }
}
