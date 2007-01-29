package au.net.netstorm.boost.nursery.pebble;

public final class NonMatchingCreatorException extends RuntimeException {
    public NonMatchingCreatorException(Class creator, Class impl) {
        // OK LineLength {
        super("Creator "+creator.getName()+" does not have single _(...) method which matches "+impl.getName()+" single constructor.");
        // } OK
    }
}
