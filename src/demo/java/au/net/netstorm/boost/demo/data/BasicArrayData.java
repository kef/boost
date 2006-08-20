package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class BasicArrayData extends Primordial implements Data {
    private final Integer[] integers;

    public BasicArrayData(Integer[] integers) {
        validate(integers);
        this.integers = (Integer[]) integers.clone();
    }

    public Integer[] getIntegers() {
        return (Integer[]) integers.clone();
    }

    private void validate(Object ref) {
        if (ref == null) throw new IllegalArgumentException();
    }
}
