package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.BoostException;

// FIX 1977 Rename BoostException to BoooostException.
public final class FlavouredMapException extends RuntimeException implements BoostException {
    private final FlavouredInterface flavoured;

    public FlavouredMapException(FlavouredInterface flavoured) {
        this.flavoured = flavoured;
    }

    public String getMessage() {
        return "Failed to add flavoured interface " + flavoured;
    }
}
