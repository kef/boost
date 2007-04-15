package au.net.netstorm.boost.spider.type;

public final class NoNewerInterfaceException extends RuntimeException {
    public NoNewerInterfaceException(String newerInterfaceName, Class impl) {
        super("No newer interface " + newerInterfaceName + " found for class " + impl.getName());
    }
}
