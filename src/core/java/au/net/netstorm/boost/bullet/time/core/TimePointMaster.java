package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.edge.java.lang.EdgeSystem;

public interface TimePointMaster {
    TimePoint next(TimePoint time);

    TimePoint previous(TimePoint time);

    TimePoint now(EdgeSystem system);

    TimePoint get(long millis);
}
