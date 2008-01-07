package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.primordial.BoooostException;

public final class FlavourMapException extends RuntimeException implements BoooostException {
    private final FlavouredInterface flavour;
    private final String reason;
    private final String things;

    public FlavourMapException(FlavouredInterface flavour, String reason) {
        this.flavour = flavour;
        this.reason = reason;
        PartialInstances partial = new DefaultPartialInstances();
        this.things = "" + partial;
    }

    public String getMessage() {
        return reason + ": " + flavour + " : " + things;
    }
}
