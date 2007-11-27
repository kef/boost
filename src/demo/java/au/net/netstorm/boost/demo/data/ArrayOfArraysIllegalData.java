package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class ArrayOfArraysIllegalData extends Primordial implements Data {
    private final byte[][] byters;

    public ArrayOfArraysIllegalData(byte[][] byters) {
        this.byters = byters;
    }

    public byte[][] getByters() {
        return byters;
    }
}
