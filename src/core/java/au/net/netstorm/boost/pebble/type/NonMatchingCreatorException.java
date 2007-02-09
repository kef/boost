package au.net.netstorm.boost.pebble.type;

import au.net.netstorm.boost.util.type.Interface;

public final class NonMatchingCreatorException extends RuntimeException {
    public NonMatchingCreatorException(Interface creator, Class impl) {
        super("Creator " + creator.getType().getName() +
                " does not have single create(...) method which matches " + impl.getName() +
                " single constructor.");
    }
}
