package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.time.core.DefaultTimePoint;
import au.net.netstorm.boost.time.core.TimePoint;

public final class TimePointProvider implements DataProvider<TimePoint> {
    private final Random random;

    public TimePointProvider(Random random) {
        this.random = random;
    }

    public TimePoint get() {
        // FIX 64166 Range support required here.
        long time = random.provide(Long.class);
        long positive = time < 0 ? -time : time;
        return new DefaultTimePoint(positive);
    }
}

