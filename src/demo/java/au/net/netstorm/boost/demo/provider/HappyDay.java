package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.util.type.Data;

public interface HappyDay extends Data {
    Long getTimeMillis();

    Happiness getHappiness();
}
