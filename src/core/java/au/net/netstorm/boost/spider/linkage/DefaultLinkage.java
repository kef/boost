package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

final class DefaultLinkage extends Primordial implements Linkage {
    private final Implementation host;
    private final Interface iface;
    private final Anchor anchor;

    public DefaultLinkage(Implementation host, Interface iface, Anchor anchor) {
        this.host = host;
        this.iface = iface;
        this.anchor = anchor;
        validate(iface);
    }

    public Implementation getHost() {
        check(host, "host");
        return host;
    }

    public Interface getIface() {
        return iface;
    }

    public Anchor getAnchor() {
        check(anchor, "anchor");
        return anchor;
    }

    public boolean hosted() {
        return host != null;
    }

    public boolean anchored() {
        return anchor != null;
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
