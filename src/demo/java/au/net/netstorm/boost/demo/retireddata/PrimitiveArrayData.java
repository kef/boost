package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class PrimitiveArrayData extends Primordial implements Data {
    private byte[] bytes;

    public PrimitiveArrayData(byte[] bytes) {
        if (bytes == null) throw new IllegalArgumentException();
        this.bytes = (byte[]) bytes.clone();
    }

    public byte[] getBytes() {
        return (byte[]) bytes.clone();
    }
}
