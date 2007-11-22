package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplMapper implements ImplMapper {
    private final ClassMaster master = new DefaultClassMaster();
    private final String prefix;

    public DefaultImplMapper(String prefix) {
        this.prefix = prefix;
    }

    public String map(Interface iface) {
        String pkg = master.getPackageName(iface);
        String cls = master.getShortName(iface);
        return pkg + "." + prefix + cls;
    }

    public boolean can(Interface iface) {
        return true;
    }
}
