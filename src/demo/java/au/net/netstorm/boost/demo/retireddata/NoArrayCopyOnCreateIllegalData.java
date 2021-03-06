package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class NoArrayCopyOnCreateIllegalData extends Primordial implements Data {
    private final Integer[] integers;

    public NoArrayCopyOnCreateIllegalData(Integer[] integers) {
        this.integers = integers;
        validate();
    }

    public Integer[] getIntegers() {
        return (Integer[]) integers.clone();
    }

    private void validate() {
        if (integers == null) throw new IllegalArgumentException();
    }
}
