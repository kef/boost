package au.net.netstorm.boost.nursery.pebble;

// FIX 1665 Move into production.
public final class NoNewInterfaceException extends RuntimeException {
    public NoNewInterfaceException(String newerInterfaceName, Class impl) {
        super("No new interface " + newerInterfaceName + " found for class " + impl.getName());
    }
}
