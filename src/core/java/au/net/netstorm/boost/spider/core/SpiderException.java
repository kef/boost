package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.primordial.BoooostException;

public abstract class SpiderException extends RuntimeException implements BoooostException {
    private final String things;

    public SpiderException() {
        this.things = things();
    }

    public SpiderException(Throwable cause) {
        super(cause);
        this.things = things();
    }

    public String getMessage() {
        return getReason() + " : " + things;
    }

    private String things() {
        PartialInstances things = new DefaultPartialInstances();
        return things.toString();
    }

    protected abstract String getReason();
}
