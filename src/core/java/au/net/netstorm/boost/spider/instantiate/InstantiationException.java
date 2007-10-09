package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.spider.core.SpiderException;

public final class InstantiationException extends SpiderException {
    private final String message;

    public InstantiationException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public InstantiationException(String message) {
        this.message = message;
    }

    protected String getReason() {
        return message;
    }
}
