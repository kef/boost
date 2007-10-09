package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.spider.core.SpiderException;
import au.net.netstorm.boost.util.type.Interface;

public final class InterfaceMapException extends SpiderException {
    private final Interface iface;
    private final String reason;

    public InterfaceMapException(Interface iface, String reason) {
        this.iface = iface;
        this.reason = reason;
    }

    protected String getReason() {
        return reason + ": " + iface;
    }
}
