package au.net.netstorm.boost.provider;

public final class NotProvidedException extends ProviderException {
    public NotProvidedException(Class type) {
        super("Could not provide type '" + type + "'.");
    }
}
