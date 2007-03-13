package au.net.netstorm.boost.pebble.type;

import au.net.netstorm.boost.util.type.Interface;

public final class NonMatchingNewerException extends RuntimeException {
    public NonMatchingNewerException(Interface newer, Class impl) {
        super("Newer " + newer.getType().getName() +
                " does not have single nu(...) method which matches " + impl.getName() +
                " single constructor.");
    }
}
