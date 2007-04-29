package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.primordial.BoostException;

public final class ScrunchException extends RuntimeException implements BoostException {
    public ScrunchException() {
        super("The object you are trying to invoke a method on has been made unusable ... SCRUNCH, YOU'RE GONE!");
    }
}
