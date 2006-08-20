package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class NoArrayCopyOnCreateIllegalData extends Primordial implements Data {
    private final Integer[] integers;

    public NoArrayCopyOnCreateIllegalData(Integer[] integers) {
        this.integers = integers;
        validate(integers);
    }

    public Integer[] getIntegers() {
        return integers;
    }

    private void validate(Object ref) {
        if (ref == null) throw new IllegalArgumentException();
    }
}
