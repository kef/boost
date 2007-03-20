package au.net.netstorm.boost.pebble.inject.newer.core;

public final class DoesNotImplementNewerException extends RuntimeException {

    // FIX 35820 Change message to something more meaningful.
    public DoesNotImplementNewerException(Class type) {
        super("No newer interface found for class " + type.getName());
    }
}
