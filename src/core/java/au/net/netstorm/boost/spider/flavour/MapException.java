package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.spider.core.SpiderException;

public final class MapException extends SpiderException {
    private final Object key;
    private final String reason;

    public MapException(Object key, String reason) {
        this.key = key;
        this.reason = reason;
    }

    protected String getReason() {
        return reason + ": " + key;
    }
}
