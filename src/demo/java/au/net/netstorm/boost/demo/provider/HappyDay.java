package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.gunge.type.Data;

public interface HappyDay extends Data {
    Long getTimeMillis();

    Happiness getHappiness();

    FancyPants getFancyPants();
}
