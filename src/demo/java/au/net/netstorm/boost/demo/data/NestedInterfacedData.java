package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;

// FIX SC600 Push methods up into interface.

final class NestedInterfacedData extends Primordial implements NestedInterface {
    private final String guitar;
    private final BasicInterface basic;

    public NestedInterfacedData(String guitar, BasicInterface basic) {
        this.guitar = guitar;
        this.basic = basic;
    }

    public String getGuitar() {
        return guitar;
    }

    public BasicInterface getBasic() {
        return basic;
    }
}
