package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.BoostException;

public final class WrongInstanceTypeException extends RuntimeException implements BoostException {

    public WrongInstanceTypeException(String message) {
        super(message);
    }
}
