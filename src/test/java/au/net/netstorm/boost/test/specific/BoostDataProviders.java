package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class BoostDataProviders implements ProvidesData {

    public void register(DataProviders data) {
        data.add(Interface.class, new InterfaceSpecificProvider());
        data.add(Implementation.class, new ImplementationSpecificProvider());
    }
}
