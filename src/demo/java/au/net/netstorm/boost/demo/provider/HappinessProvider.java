package au.net.netstorm.boost.demo.provider;

import java.util.Random;
import au.net.netstorm.boost.test.specific.TargettedProvider;

public class HappinessProvider implements TargettedProvider {
    public Object get() {
        Random random = new Random();
        int value = random.nextInt(4) % 4;
        if (value == 1) return DefaultHappiness.ECSTATIC;
        if (value == 2) return DefaultHappiness.GRINNIN;
        if (value == 3) return DefaultHappiness.SMILEY;
        return DefaultHappiness.COOL;
    }
}
