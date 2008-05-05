package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.bullet.primmm.Primordial;

public final class DefaultHappyDay extends Primordial implements HappyDay {
    private Long timeMillis;
    private Happiness happiness;
    private FancyPants fancyPants;

    public DefaultHappyDay(Long timeMillis, Happiness happiness, FancyPants fancyPants) {
        this.timeMillis = timeMillis;
        this.happiness = happiness;
        this.fancyPants = fancyPants;
    }

    public Long getTimeMillis() {
        return timeMillis;
    }

    public Happiness getHappiness() {
        return happiness;
    }

    public FancyPants getFancyPants() {
        return fancyPants;
    }
}
