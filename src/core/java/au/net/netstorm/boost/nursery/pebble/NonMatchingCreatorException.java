package au.net.netstorm.boost.nursery.pebble;

import au.net.netstorm.boost.util.type.Interface;

public final class NonMatchingCreatorException extends RuntimeException {
    public NonMatchingCreatorException(Interface creator, Class impl) {
        // OK LineLength {
        super("Creator "+creator.getType().getName()+" does not have single _(...) method which matches "+impl.getName()+" single constructor.");
        // } OK
    }
}
