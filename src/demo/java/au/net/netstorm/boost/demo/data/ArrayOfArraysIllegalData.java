package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class ArrayOfArraysIllegalData extends Primordial implements Data {
    private final float[][] floaters;

    public ArrayOfArraysIllegalData(float[][] floaters) {
        this.floaters = floaters;
    }

    public float[][] getFloaters() {
        return floaters;
    }
}
