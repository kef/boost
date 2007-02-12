package au.net.netstorm.boost.pebble.create;

public final class DoesNotImplementNewerException extends RuntimeException {

    public DoesNotImplementNewerException(Class type) {
        super("No creator interface found for class " + type.getName());
    }
}
