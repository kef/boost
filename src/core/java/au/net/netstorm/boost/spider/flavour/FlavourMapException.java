package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.BoostException;

// FIX 1977 Rename BoostException to BoooostException.
public final class FlavourMapException extends RuntimeException implements BoostException {
    private final FlavouredInterface flavour;
    private final String reason;

    public FlavourMapException(FlavouredInterface flavour, String reason) {
        this.flavour = flavour;
        this.reason = reason;
    }

    public String getMessage() {
        return "Failed to add flavoured interface " + flavour + ".  " + reason + ".";
    }
}
