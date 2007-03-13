package au.net.netstorm.boost.pebble.create.core;

public final class DoesNotImplementCreatorException extends RuntimeException {

    public DoesNotImplementCreatorException(Class type) {
        super("No creator interface found for class " + type.getName());
    }
}
