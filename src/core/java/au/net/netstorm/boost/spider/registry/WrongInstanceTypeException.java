package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.BoooostException;

public final class WrongInstanceTypeException extends RuntimeException implements BoooostException {

    public WrongInstanceTypeException(String message) {
        super(message);
    }
}
