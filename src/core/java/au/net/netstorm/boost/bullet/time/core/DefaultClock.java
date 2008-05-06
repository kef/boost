package au.net.netstorm.boost.bullet.time.core;

import au.net.netstorm.boost.edge.java.lang.EdgeSystem;

public final class DefaultClock implements Clock {
    TimePointMaster drWho;
    EdgeSystem system;

    public TimePoint now() {
        return drWho.now(system);
    }
}
