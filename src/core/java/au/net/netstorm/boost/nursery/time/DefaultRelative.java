package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultRelative extends Primordial implements Relative {
    private final long offset;

    public DefaultRelative(long offset) {
        this.offset = offset;
        if (offset < 0) throw new IllegalStateException("Offset " + offset + " cannot be less than ZERO");
    }

    public long getOffset() {
        return offset;
    }
}
