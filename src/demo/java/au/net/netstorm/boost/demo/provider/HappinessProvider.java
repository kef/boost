package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.test.specific.DataProvider;

import java.util.Random;

public class HappinessProvider implements DataProvider<Happiness> {
    public Happiness get() {
        Random random = new Random();
        int value = random.nextInt(4) % 4;
        if (value == 1) return DefaultHappiness.ECSTATIC;
        if (value == 2) return DefaultHappiness.GRINNIN;
        if (value == 3) return DefaultHappiness.SMILEY;
        return DefaultHappiness.COOL;
    }
}
