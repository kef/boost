package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.gunge.type.Data;

import java.io.Serializable;

public interface TimePoint extends Data, Serializable, Comparable {
    Long getMillis();

    Boolean before(TimePoint b);

    Boolean after(TimePoint b);
}
