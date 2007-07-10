package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultHappyDay extends Primordial implements HappyDay {
    private long timeMillis;
    private Happiness happiness;

    public DefaultHappyDay(long timeMillis, Happiness happiness) {
        this.timeMillis = timeMillis;
        this.happiness = happiness;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public Happiness getHappiness() {
        return happiness;
    }
}
