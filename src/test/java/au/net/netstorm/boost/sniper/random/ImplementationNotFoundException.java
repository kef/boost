package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.bullet.provider.ProviderException;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.specific.DataProvider;

public final class ImplementationNotFoundException extends ProviderException {
    private static final String DATA_PROVIDER = DataProvider.class.getName();

    public ImplementationNotFoundException(Interface type) {
        super("No implementation found for '" + type.getType() + "'. You may need to register a " + DATA_PROVIDER);
    }
}
