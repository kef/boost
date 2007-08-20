package au.net.netstorm.boost.nursery.type;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultAsciiBytes extends Primordial implements AsciiBytes {
    private final byte[] value;

    public DefaultAsciiBytes(byte[] value) {
        if (value == null) throw new IllegalArgumentException();
        this.value = value;
    }

    public byte[] getValue() {
        return value;
    }
}