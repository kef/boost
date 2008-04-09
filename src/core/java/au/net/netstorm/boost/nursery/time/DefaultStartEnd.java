package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class DefaultStartEnd extends Primordial implements StartEnd {
    private final TimeSpec start;
    private final TimeSpec end;

    public DefaultStartEnd(TimeSpec start, TimeSpec end) {
        this.start = start;
        this.end = end;
        validate();
    }

    private void validate() {
        if (start == null) throw new IllegalArgumentException();
        if (end == null) throw new IllegalArgumentException();
    }

    public TimeSpec getStart() {
        return start;
    }

    public TimeSpec getEnd() {
        return end;
    }
}
