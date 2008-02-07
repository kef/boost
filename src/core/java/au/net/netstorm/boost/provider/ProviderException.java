package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.primordial.PrimordialException;

public class ProviderException extends PrimordialException {
    public ProviderException(String message) {
        super(message);
    }

    public ProviderException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
