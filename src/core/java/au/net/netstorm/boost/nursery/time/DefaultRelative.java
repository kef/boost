package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.primmm.Primordial;

public final class DefaultRelative extends Primordial implements Relative {
    private final Long offset;

    public DefaultRelative(Long offset) {
        this.offset = offset;
        if (offset < 0) throw new IllegalStateException("Offset " + offset + " cannot be less than ZERO");
    }

    public Long getOffset() {
        return offset;
    }
}
