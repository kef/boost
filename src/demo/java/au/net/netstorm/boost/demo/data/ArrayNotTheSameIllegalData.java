package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class ArrayNotTheSameIllegalData extends Primordial implements Data {
    private final Integer[] integers;

    public ArrayNotTheSameIllegalData(Integer[] integers) {
        validate(integers);
        this.integers = (Integer[]) integers.clone();
    }

    public Integer[] getIntegers() {
        Integer[] result = (Integer[]) integers.clone();
        result[0] = new Integer(42);
        return result;
    }

    private void validate(Object ref) {
        if (ref == null) throw new IllegalArgumentException();
    }
}
