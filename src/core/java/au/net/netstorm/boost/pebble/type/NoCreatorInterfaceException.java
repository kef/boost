package au.net.netstorm.boost.pebble.type;

public final class NoCreatorInterfaceException extends RuntimeException {
    public NoCreatorInterfaceException(String creatorInterfaceName, Class impl) {
        super("No creator interface " + creatorInterfaceName + " found for class " + impl.getName());
    }
}
