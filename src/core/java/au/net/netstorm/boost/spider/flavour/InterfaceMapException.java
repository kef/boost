package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.util.type.Interface;

public final class InterfaceMapException extends RuntimeException implements BoooostException {
    private final Interface iface;
    private final String reason;
    private final String things;

    public InterfaceMapException(Interface iface, String reason) {
        this.iface = iface;
        this.reason = reason;
        ResolvedThings things = new DefaultResolvedThings();
        this.things = "" + things;
    }

    public String getMessage() {
        return reason + ": " + iface + " : " + things;
    }
}
