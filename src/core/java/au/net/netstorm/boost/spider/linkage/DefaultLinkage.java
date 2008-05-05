package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

final class DefaultLinkage extends Primordial implements Linkage {
    private final Implementation host;
    private final Interface iface;
    private final String name;

    public DefaultLinkage(Implementation host, Interface iface, String name) {
        this.host = host;
        this.iface = iface;
        this.name = name;
        validate(iface);
    }

    public Implementation getHost() {
        check(host, "host");
        return host;
    }

    public Interface getIface() {
        return iface;
    }

    public String getName() {
        check(name, "name");
        return name;
    }

    public boolean hosted() {
        return host != null;
    }

    public boolean named() {
        return name != null;
    }

    public int hashCode() {
        return iface.hashCode();
    }

    private void check(Object ref, String s) {
        if (ref == null) throw new IllegalStateException("No " + s + " specified");
    }

    private void validate(Interface iface) {
        if (iface == null) throw new IllegalStateException("No nulls.");
    }
}
