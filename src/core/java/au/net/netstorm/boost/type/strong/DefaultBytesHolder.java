package au.net.netstorm.boost.type.strong;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultBytesHolder extends Primordial implements BytesHolder {
    private final byte[] value;

    public DefaultBytesHolder(byte[] value) {
        if (value == null) throw new IllegalArgumentException();
        this.value = (byte[]) value.clone();
    }

    public byte[] getValue() {
        return (byte[]) value.clone();
    }
}
