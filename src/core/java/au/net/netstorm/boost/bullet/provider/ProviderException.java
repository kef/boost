package au.net.netstorm.boost.bullet.provider;

import au.net.netstorm.boost.bullet.primmm.PrimordialException;

public class ProviderException extends PrimordialException {
    public ProviderException(String message) {
        super(message);
    }

    public ProviderException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
