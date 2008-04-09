package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.gunge.impl.ImplMapper;
import au.net.netstorm.boost.gunge.type.Interface;

public class PackageImplMapper implements ImplMapper {
    private ClassMaster master = new DefaultClassMaster();
    private final String dst;
    private final String src;

    public PackageImplMapper(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    public String map(Interface iface) {
        String cls = master.getShortName(iface);
        return dst + ".Default" + cls;
    }

    public boolean can(Interface iface) {
        String pkg = master.getPackageName(iface);
        return pkg.equals(src);
    }
}
