package au.net.netstorm.boost.demo.provider;

import java.util.Random;
import au.net.netstorm.boost.test.specific.SpecificProvider;

public class HappinessProvider implements SpecificProvider {
    private Random random = new Random();
    private int value = random.nextInt(4) % 4;

    public Object get() {
        if (value == 1) return DefaultHappiness.ECSTATIC;
        if (value == 2) return DefaultHappiness.GRINNIN;
        if (value == 3) return DefaultHappiness.SMILEY;
        return DefaultHappiness.COOL;
    }
}
