package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.field.BoostField;

public final class BoostFieldRandomizer implements Randomizer {
    private Provider randomProvider;

    public BoostFieldRandomizer(Provider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public void randomize(BoostField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            randomize(fields[i]);
        }
    }

    private void randomize(BoostField field) {
        Class cls = field.getType();
        Object random = randomProvider.provide(cls);
        field.set(random);
    }
}
