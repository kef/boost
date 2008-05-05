package au.net.netstorm.boost.gunge.type;

import au.net.netstorm.boost.bullet.primmm.Primordial;

public final class DefaultAsciiBytes extends Primordial implements AsciiBytes {
    private final byte[] value;

    public DefaultAsciiBytes(byte[] value) {
        if (value == null) throw new IllegalArgumentException();
        this.value = (byte[]) value.clone();
    }

    public byte[] getValue() {
        return (byte[]) value.clone();
    }
}
