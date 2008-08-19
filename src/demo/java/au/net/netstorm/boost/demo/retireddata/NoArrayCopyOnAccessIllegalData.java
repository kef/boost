package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class NoArrayCopyOnAccessIllegalData extends Primordial implements Data {
    private final Integer[] integers;

    public NoArrayCopyOnAccessIllegalData(Integer[] integers) {
        validate(integers);
        this.integers = (Integer[]) integers.clone();
    }

    public Integer[] getIntegers() {
        return integers;
    }

    private void validate(Object ref) {
        if (ref == null) throw new IllegalArgumentException();
    }
}
