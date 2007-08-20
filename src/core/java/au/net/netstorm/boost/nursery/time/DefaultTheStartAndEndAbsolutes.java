package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.time.core.TimePoint;

public final class DefaultTheStartAndEndAbsolutes extends Primordial implements TheStartAndEndAbsolutes {
    private final TimePoint start;
    private final TimePoint end;

    public DefaultTheStartAndEndAbsolutes(TimePoint start, TimePoint end) {
        this.start = start;
        this.end = end;
        validate();
    }

    public TimePoint getStart() {
        return start;
    }

    public TimePoint getEnd() {
        return end;
    }

    private void validate() {
        if (start == null) throw new IllegalArgumentException();
        if (end == null) throw new IllegalArgumentException();
    }
}
