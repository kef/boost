package au.net.netstorm.boost.gunge.impl;

import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.gunge.type.Interface;

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
