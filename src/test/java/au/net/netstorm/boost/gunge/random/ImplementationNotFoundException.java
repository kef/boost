package au.net.netstorm.boost.gunge.random;

import au.net.netstorm.boost.gunge.specific.DataProvider;
import au.net.netstorm.boost.provider.ProviderException;
import au.net.netstorm.boost.util.type.Interface;

public final class ImplementationNotFoundException extends ProviderException {
    private static final String DATA_PROVIDER = DataProvider.class.getName();

    public ImplementationNotFoundException(Interface type) {
        super("No implementation found for '" + type.getType() + "'. You may need to register a " + DATA_PROVIDER);
    }
}
