package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.ProviderException;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.type.Interface;

public final class ImplementationNotFoundException extends ProviderException {
    private static final ClassMaster CLASSER = new DefaultClassMaster();

    public ImplementationNotFoundException(Interface type) {
        super("No implementation found for '" + type.getType() + "'. You may need to register a " + shortName(type));
    }

    private static String shortName(Interface type) {
        return CLASSER.getShortName(type);
    }
}
