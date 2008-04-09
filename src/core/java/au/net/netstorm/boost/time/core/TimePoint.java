package au.net.netstorm.boost.time.core;

import java.io.Serializable;
import au.net.netstorm.boost.gunge.type.Data;

public interface TimePoint extends Data, Serializable, Comparable {
    Long getMillis();

    Boolean before(TimePoint b);

    Boolean after(TimePoint b);
}
