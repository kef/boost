package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.BoooostException;

public final class FlavourMapException extends RuntimeException implements BoooostException {
    private final FlavouredInterface flavour;
    private final String reason;

    public FlavourMapException(FlavouredInterface flavour, String reason) {
        this.flavour = flavour;
        this.reason = reason;
    }

    public String getMessage() {
        return reason + ": " + flavour;
    }
}
