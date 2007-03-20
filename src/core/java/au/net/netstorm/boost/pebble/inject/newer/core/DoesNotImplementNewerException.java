package au.net.netstorm.boost.pebble.inject.newer.core;

public final class DoesNotImplementNewerException extends RuntimeException {

    // FIX 35820 Change message to something more meaningful.
    // FIX 35820 Pass in marker interface.
    public DoesNotImplementNewerException(Class type) {
        super("No newer interface found for class " + type.getName());
    }
}
