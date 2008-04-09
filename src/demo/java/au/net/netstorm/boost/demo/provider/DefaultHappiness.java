package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public class DefaultHappiness extends Primordial implements Happiness {
    public static final Happiness COOL = new DefaultHappiness("COOL");
    public static final Happiness SMILEY = new DefaultHappiness("SMILEY");
    public static final Happiness GRINNIN = new DefaultHappiness("GRINNIN");
    public static final Happiness ECSTATIC = new DefaultHappiness("ECSTATIC");
    private String name;

    private DefaultHappiness(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
