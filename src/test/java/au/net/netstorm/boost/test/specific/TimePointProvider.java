package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.time.core.DefaultTimePoint;
import au.net.netstorm.boost.util.type.Data;

public final class TimePointProvider implements DataProvider {
    private final Provider random;

    public TimePointProvider(Provider random) {
        this.random = random;
    }

    public Data get() {
        // FIX 64166 Range support required here.
        long time = random.provide(Long.class);
        long positive = time < 0 ? -time : time;
        return new DefaultTimePoint(positive);
    }
}

