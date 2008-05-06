package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sniper.field.BoostField;

public final class BoostFieldRandomizer implements Randomizer {
    private Provider randomProvider;

    public BoostFieldRandomizer(Provider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public void randomize(BoostField[] fields) {
        for (BoostField field : fields) {
            randomize(field);
        }
    }

    private void randomize(BoostField field) {
        Class cls = field.getType();
        Object random = randomProvider.provide(cls);
        field.set(random);
    }
}
