package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class BasicArrayData extends Primordial implements Data {
    private final Integer[] integers;

    public BasicArrayData(Integer[] integers) {
        this.integers = integers;
        validate();
    }

    public Integer[] getIntegers() {
        return integers;
    }

    private void validate() {
        if (integers == null) throw new IllegalArgumentException();
    }
}
