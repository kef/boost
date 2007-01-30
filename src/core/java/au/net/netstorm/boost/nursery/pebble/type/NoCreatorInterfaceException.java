package au.net.netstorm.boost.nursery.pebble.type;

public final class NoCreatorInterfaceException extends RuntimeException {
    public NoCreatorInterfaceException(String newerInterfaceName, Class impl) {
        super("No newer interface " + newerInterfaceName + " found for class " + impl.getName());
    }
}
