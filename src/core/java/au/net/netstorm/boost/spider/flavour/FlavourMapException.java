package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.demo.spider.newer.DefaultResolvedThings;
import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.primordial.BoooostException;

public final class FlavourMapException extends RuntimeException implements BoooostException {
    private final FlavouredInterface flavour;
    private final String reason;
    private final String things;

    public FlavourMapException(FlavouredInterface flavour, String reason) {
        this.flavour = flavour;
        this.reason = reason;
        ResolvedThings things = new DefaultResolvedThings();
        this.things = "" + things;
    }

    public String getMessage() {
        return reason + ": " + flavour + " : " + things;
    }
}
