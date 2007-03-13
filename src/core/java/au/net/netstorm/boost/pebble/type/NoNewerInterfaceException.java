package au.net.netstorm.boost.pebble.type;

public final class NoNewerInterfaceException extends RuntimeException {
    public NoNewerInterfaceException(String creatorInterfaceName, Class impl) {
        super("No creator interface " + creatorInterfaceName + " found for class " + impl.getName());
    }
}
