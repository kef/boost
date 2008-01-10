package au.net.netstorm.boost.nursery.spider.linkage;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX ()   2237 Move out of "nursery".
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

    // FIX () BREADCRUMB   2237 SSSSSSSSSSSSSSSSSSSSSSSS hashCode/equals for our map.
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
        int result = 0;
        result = hash(result, host);
        result = hash(result, iface);
        result = hash(result, name);
        return result;
    }

    private void check(Object ref, String s) {
        if (ref == null) throw new IllegalStateException("No " + s + " specified");
    }

    private void validate(Interface iface) {
        if (iface == null) throw new IllegalStateException("No nulls.");
    }

    private int hash(int result, Object ref) {
        return 31 * result + (ref != null ? ref.hashCode() : 0);
    }
}
