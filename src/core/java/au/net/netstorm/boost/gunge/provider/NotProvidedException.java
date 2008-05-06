package au.net.netstorm.boost.gunge.provider;

public final class NotProvidedException extends ProviderException {
    public NotProvidedException(Class type) {
        super("Could not provide type '" + type + "'.");
    }
}
