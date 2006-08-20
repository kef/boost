package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;

final class NestedInterfacedData extends Primordial implements NestedInterface {
    private final String guitar;
    private final BasicInterface basic;

    public NestedInterfacedData(String guitar, BasicInterface basic) {
        this.guitar = guitar;
        this.basic = basic;
        validate();
    }

    public String getGuitar() {
        return guitar;
    }

    public BasicInterface getBasic() {
        return basic;
    }

    private void validate() {
        validate(guitar);
        validate(basic);
    }

    private void validate(Object ref) {
        if (ref == null) throw new IllegalArgumentException();
    }
}
