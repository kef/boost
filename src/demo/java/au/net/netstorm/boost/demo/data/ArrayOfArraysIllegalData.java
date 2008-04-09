package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class ArrayOfArraysIllegalData extends Primordial implements Data {
    private final byte[][] byters;

    public ArrayOfArraysIllegalData(byte[][] byters) {
        this.byters = byters;
    }

    public byte[][] getByters() {
        return byters;
    }
}
