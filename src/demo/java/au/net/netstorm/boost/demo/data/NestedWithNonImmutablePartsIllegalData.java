package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;

final class NestedWithNonImmutablePartsIllegalData extends Primordial implements NestedInterface {
    private final String guitar;
    private final BasicInterface basic;

    public NestedWithNonImmutablePartsIllegalData(String guitar, BasicInterface basic) {
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
