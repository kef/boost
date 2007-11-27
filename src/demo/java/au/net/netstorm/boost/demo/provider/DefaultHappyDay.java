package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultHappyDay extends Primordial implements HappyDay {
    private Long timeMillis;
    private Happiness happiness;

    public DefaultHappyDay(Long timeMillis, Happiness happiness) {
        this.timeMillis = timeMillis;
        this.happiness = happiness;
    }

    public Long getTimeMillis() {
        return timeMillis;
    }

    public Happiness getHappiness() {
        return happiness;
    }
}
