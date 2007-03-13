package au.net.netstorm.boost.pebble.newer.core;

public final class DoesNotImplementNewerException extends RuntimeException {

    public DoesNotImplementNewerException(Class type) {
        super("No creator interface found for class " + type.getName());
    }
}
